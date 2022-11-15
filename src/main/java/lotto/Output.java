package lotto;

import java.util.List;

public class Output {
    private static final int FIRSTPRICE=2000000000;
    private static final int SECONDPRICE=30000000;
    private static final int THIRDPRICE=1500000;
    private static final int FOURTHPRICE=50000;
    private static final int FIFTHPRICE=5000;

    public void printLotto(List<List<Integer>> allLotto ){
        int lottoCount=allLotto.size();
        System.out.println(lottoCount+"개를 구매했습니다.");
        for(List<Integer> lotto:allLotto){
            System.out.println(lotto);
        }
    }

    public int printWinningRate(List<Integer> winningCount){
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 ("+FIFTHPRICE+"원) - "+winningCount.get(4)+"개");
        System.out.println("4개 일치 ("+FOURTHPRICE+"원) - "+winningCount.get(3)+"개");
        System.out.println("5개 일치 ("+THIRDPRICE+"원) - "+winningCount.get(2)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 ("+SECONDPRICE+"원) - "+winningCount.get(1)+"개");
        System.out.println("6개 일치 ("+FIRSTPRICE+"원) - "+winningCount.get(0)+"개");

        int earnedMoney=FIRSTPRICE*winningCount.get(0)+SECONDPRICE*winningCount.get(1)+
                THIRDPRICE*winningCount.get(2)+FOURTHPRICE*winningCount.get(3)+
                FIFTHPRICE*winningCount.get(4);

        return earnedMoney;
    }

    public void printProfitRate(int earnedMoney, int payedMoney){
        double profitRate=(payedMoney/earnedMoney)*100;
        System.out.println("총 수익률은 "+String.format("%.1f",profitRate)+"%입니다.");
    }
}
