package OnlineAuction.controller;

import OnlineAuction.entity.*;
import OnlineAuction.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PlumbRestController {

    @Autowired
    PlumbService plumbService;
    @Autowired
    PictureService pictureService;
    @Autowired
    PicturePhotoService picturePhotoService;
    @Autowired
    BetService betService;
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    MailService mailService;

    @GetMapping("/plumbWithoutConfirmed")
    public List<Plumb> plumbWithoutConfirmed() {
        return plumbService.plumbWithoutConfirmed();
    }

    @DeleteMapping("/deletePlumb{id}")
    public void deletePlumb(@PathVariable("id") int deleteId) {
        Plumb plumb = plumbService.findOneByIdWithPicture(deleteId);
        Picture picture = plumb.getPicture();
        betService.removeBets(plumb);
        picturePhotoService.removeByPicture(picture);
        plumbService.delete(deleteId);
        pictureService.delete(picture.getId());
    }

    @GetMapping("/allPlumbs")
    public List<Plumb> allPlumbs() {
        List<Plumb> plumbs = new ArrayList<Plumb>(plumbService.findAllPlumbWithPicture());
        return plumbs;
    }

    @PostMapping("/resetPlumb-{plumbId}")
    public void editNameOfUser(@PathVariable("plumbId")int plumbId, @RequestBody String stringDateOfEnd) throws ParseException {
        String[] splitDate = stringDateOfEnd.split("T");
        stringDateOfEnd = splitDate[0] + " " + splitDate[1];
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd hh:mm");
        Date dateOfEnd = format.parse(stringDateOfEnd);
        Date currentDate = new Date();
        plumbService.resetPlumb(plumbId, dateOfEnd, currentDate);
    }

    @PostMapping("/editPlumbName-{pictureId}")
    public void editPlumbName(@PathVariable("pictureId")int pictureid, @RequestBody String newName){
        pictureService.editPlumbName(newName, pictureid);
    }

    @PostMapping("/editPlumbCategory-{pictureId}")
    public void editPlumbCategory(@PathVariable("pictureId")int pictureid, @RequestBody String stringCategory){
        Category category = categoryService.findCategoryByName(stringCategory);
        pictureService.editPlumbCategory(category, pictureid);
    }

    @PostMapping("/confirmDeliverPlumb")
    public void confirmPlumb(@RequestBody String plumbId){
        int plumbIdInt = Integer.parseInt(plumbId);
        plumbService.confirmDeliverPlumb(plumbIdInt);
    }

}
