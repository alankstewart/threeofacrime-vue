package alankstewart.threeofacrime.web;

import alankstewart.threeofacrime.model.Suspect;
import alankstewart.threeofacrime.model.SuspectCard;
import alankstewart.threeofacrime.service.ThreeOfACrimeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class ThreeOfACrimeController {

    @Resource
    private ThreeOfACrimeService threeOfACrimeService;

    @GetMapping(value = "/suspects")
    public List<Suspect> getSuspects() {
        return Stream.of(Suspect.values()).collect(toList());
    }

    @PostMapping("/play")
    public List<String> getSuspectCards(@RequestBody SuspectMatchDto suspectMatchDto) {
        return threeOfACrimeService.getSuspectCards().stream()
                .map(SuspectCard::toString)
                .collect(toList());
    }
}
