package org.example.assertTrue;

import org.example.model.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberTest {
    @Test
    void testAPayeCotisation(){
        Member member = new Member("Mathys");
        member.payerCotisation();
        Assertions.assertTrue(member.aPayeCotisation(), "Le membre doit avoir payé");

    }

    @Test
    void membreAtteintQuota(){
        Member member = new Member("booby");
        for (int i=0; i<5; i++){
            member.ajouterLivreLu();
        }
        Assertions.assertTrue(member.aAtteintLeQuotaLivres(5), "Le membre doit avoir atteint son quota");
    }
}
