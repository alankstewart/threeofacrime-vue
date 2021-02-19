package alankstewart.threeofacrime.web;

import alankstewart.threeofacrime.model.Suspect;
import alankstewart.threeofacrime.model.SuspectCard;
import alankstewart.threeofacrime.service.ThreeOfACrimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@RestController
public class ThreeOfACrimeController {

    @Resource
    private ThreeOfACrimeService threeOfACrimeService;

    @GetMapping(value = "/suspects")
    public List<Suspect> getSuspects() {
        return Stream.of(Suspect.values()).collect(toList());
    }

    @GetMapping("/suspectCards")
    public List<SuspectCard> getSuspectCards() {
        return threeOfACrimeService.getSuspectCards();
    }
}
