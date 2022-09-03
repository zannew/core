package hellospring.core.discount;

import hellospring.core.member.Grade;
import hellospring.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int dicsountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return dicsountFixAmount;
        }
        return 0;
    }
}
