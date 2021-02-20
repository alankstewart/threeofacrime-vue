package alankstewart.threeofacrime.service;

import alankstewart.threeofacrime.model.SuspectCard;
import org.springframework.stereotype.Service;

import java.util.List;

import static alankstewart.threeofacrime.model.Suspect.*;

@Service
public class ThreeOfACrimeService {

    public List<SuspectCard> getSuspectCards() {
        return List.of(
                SuspectCard.of(NO_NECK_NICK, KID_CASSIDY, LOOSE_EYE_LENNY),
                SuspectCard.of(HUMPTY_BUMPTY, JONNY_CORTEX, PENCIL_TOP));

    }
}
