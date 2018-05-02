package OnlineAuction.controller;

import OnlineAuction.entity.Category;
import OnlineAuction.entity.Picture;
import OnlineAuction.entity.Plumb;
import OnlineAuction.service.PicturePhotoService;
import OnlineAuction.service.PictureService;
import OnlineAuction.service.PlumbService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlumbRestController {

    @Autowired
    PlumbService plumbService;
    @Autowired
    PictureService pictureService;
    @Autowired
    PicturePhotoService picturePhotoService;

    @GetMapping("/plumbWithoutConfirmed")
    public List<Plumb> plumbWithoutConfirmed(){
        return plumbService.plumbWithoutConfirmed();
    }

    @DeleteMapping("/deletePlumb{id}")
    public void deletePlumb(@PathVariable("id")int deleteId){
        Plumb plumb = plumbService.findOneByIdWithPicture(deleteId);
        Picture picture = plumb.getPicture();
        picturePhotoService.removeByPicture(picture);
        plumbService.delete(deleteId);
        pictureService.delete(picture.getId());

    }




}
