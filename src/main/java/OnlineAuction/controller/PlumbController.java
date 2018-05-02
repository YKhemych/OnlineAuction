package OnlineAuction.controller;

import OnlineAuction.entity.*;
import OnlineAuction.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PlumbController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    AuthorService authorService;
    @Autowired
    PicturePhotoService picturePhotoService;
    @Autowired
    PictureService pictureService;
    @Autowired
    UserService userService;
    @Autowired
    PlumbService plumbService;


    @GetMapping("/createPlumb")
    public String createPlumb(Model model){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("authors", authorService.findAll());
        return "createPlumb";
    }

    @PostMapping("/create/savePlumbBy{user}")
    public String savePlumb(@PathVariable("user")String userName, @RequestParam String name, @RequestParam String categoryName,
                            @RequestParam List<MultipartFile> picturePhotoList, @RequestParam String year, @RequestParam String size,
                            @RequestParam String material, @RequestParam String authorName, @RequestParam int price,
                            @RequestParam String stringDateOfEnd, @RequestParam String condition, @RequestParam String description) throws IOException, ParseException {
        Category category = categoryService.findCategoryByName(categoryName);
        Author author = authorService.findAuthorByName(authorName);
        Picture picture = new Picture(name, size, year, author, category, material, condition, description);
        pictureService.save(picture);
        savePhoto(picturePhotoList, picture);
        User user = userService.findByName(userName);
        String[] splitDate = stringDateOfEnd.split("T");
        stringDateOfEnd = splitDate[0] + " " + splitDate[1];
//        System.out.println(stringDateOfEnd);
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd hh:mm");
        Date dateOfEnd = format.parse(stringDateOfEnd);
//        System.out.println(date);
        Date currentDate = new Date();
//        System.out.println(currentDate);
        Plumb plumb = new Plumb(picture, user, price,currentDate,dateOfEnd,false);
        plumbService.save(plumb);
        return "redirect:/userPage";
    }

    public void savePhoto(@RequestParam List<MultipartFile> picturePhotoList, Picture picture) throws IOException {
        for (MultipartFile pictutePhoto: picturePhotoList) {
            String realPath = System.getProperty("user.home") + File.separator + "auctionImages" + File.separator;
            pictutePhoto.transferTo(new File(realPath + pictutePhoto.getOriginalFilename()));
            PicturePhoto photo = PicturePhoto
                    .builder()
                    .photo("/photo/" + pictutePhoto.getOriginalFilename())
                    .picture(picture)
                    .build();
            picturePhotoService.save(photo);
        }
    }


    @GetMapping("/plumb{id}")
    public String createPlumb(@PathVariable("id")int id, Model model){
        Plumb plumb = plumbService.findOneByIdWithPicture(id);
//        System.out.println(plumb);
        Picture picture = plumb.getPicture();
//        System.out.println(picture);
        List<PicturePhoto> picturePhotos = picturePhotoService.findAllByPicture(picture);
        model.addAttribute("plumb", plumb);
        model.addAttribute("picture", picture);
        model.addAttribute("picturePhotos", picturePhotos);
        model.addAttribute("currentDate", new Date());
        return "plumbPage";
    }

    @GetMapping("/confirmPlumb{id}")
    public String confirmPlumb(@PathVariable("id")int id){
        System.out.println(id);
        plumbService.confirmPlumb(id);
        return "adminPage";
    }

    @GetMapping("/plumbs/category{id}/page{page}")
    public String plumbsWithCategory(@PathVariable("id")int categoryId, @PathVariable("page")int page, Model model){
        Category category = categoryService.findOne(categoryId);
        System.out.println(category);
        Date currentDate = new Date();
        List<Plumb> plumbs = new ArrayList<Plumb>(plumbService.findActivePlumbByCategoryWithPictureAndPhoto(category, currentDate, new PageRequest(page, 20)));
        model.addAttribute("plumbs", plumbs);
        model.addAttribute("currentDate", currentDate);
        return "listPlumbs";
    }

    @GetMapping("/allActivePlumb-Page{page}")
    public String allActivePlumbs(@PathVariable("page")int page, Model model){
        Date currentDate = new Date();
        List<Plumb> plumbs = new ArrayList<Plumb>(plumbService.allActivePlumbs(currentDate, new PageRequest(page, 20)));
        model.addAttribute("plumbs", plumbs);
        model.addAttribute("currentDate", currentDate);
        return "listPlumbs";
    }


}
