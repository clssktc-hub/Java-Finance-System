import java.util.Scanner;

public class PersonalFinanceSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("====================================");
        System.out.println("   歡迎使用個人理財分析系統");
        System.out.println("   作者：Jocelyn Wang");
        System.out.println("====================================\n");

        while (true) {
            System.out.println("\n請選擇功能：");
            System.out.println("1. 財務健康檢查");
            System.out.println("2. 單筆投資計算");
            System.out.println("3. 定期定額模擬");
            System.out.println("4. 投資組合評估");
            System.out.println("5. 房貸計算");
            System.out.println("0. 離開系統");
            System.out.print("請輸入選項 (0-5)：");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    financialHealthCheck(scanner);
                    break;
                case 2:
                    calculateFutureValue(scanner);
                    break;
                case 3:
                    simulateRecurringInvestment(scanner);
                    break;
                case 4:
                    assessPortfolioRisk(scanner);
                    break;
                case 5:
                    calculateMortgage(scanner);
                    break;
                case 0:
                    System.out.println("\n感謝使用本系統，祝您理財順利！");
                    scanner.close();
                    return;
                default:
                    System.out.println("\n無效的選項，請輸入 0-5 之間的數字。");
            }
        }
    }

    public static void financialHealthCheck(Scanner scanner) {
        double[] income = new double[6];
        double[] expense = new double[6];
        double[] saving = new double[6];

        System.out.println("\n====== 財務健康檢查 ======");
        System.out.println("請輸入過去6個月的收入與支出：");

        for (int i = 0; i < 6; i++) {
            System.out.print("第 " + (i + 1) + " 月收入：");
            income[i] = scanner.nextDouble();
            System.out.print("第 " + (i + 1) + " 月支出：");
            expense[i] = scanner.nextDouble();
        }

        double maxSaving = Double.NEGATIVE_INFINITY;
        double minSaving = Double.POSITIVE_INFINITY;
        int maxMonth = 0;
        int minMonth = 0;
        double totalSaving = 0;

        for (int i = 0; i < 6; i++) {
            saving[i] = income[i] - expense[i];
            totalSaving += saving[i];

            if (saving[i] > maxSaving) {
                maxSaving = saving[i];
                maxMonth = i + 1;
            }
            if (saving[i] < minSaving) {
                minSaving = saving[i];
                minMonth = i + 1;
            }
        }

        double averageSaving = totalSaving / 6;

        System.out.println("\n====== 分析報告 ======");
        System.out.println("學號：311357137");
        System.out.println("姓名：王盈幀");
        System.out.printf("您的平均每月儲蓄為：%.2f 元。\n", averageSaving);
        System.out.printf("儲蓄最高的月份是第 %d 月，金額：%.2f 元。\n", maxMonth, maxSaving);
        System.out.printf("儲蓄最低的月份是第 %d 月，金額：%.2f 元。\n", minMonth, minSaving);
    }

    public static void calculateFutureValue(Scanner scanner) {
        System.out.println("\n====== 單筆投資計算 ======");

        System.out.print("請輸入本金（元）：");
        double principal = scanner.nextDouble();

        System.out.print("請輸入年化報酬率（例如5%輸入0.05）：");
        double annualRate = scanner.nextDouble();

        System.out.print("請輸入投資年數：");
        int years = scanner.nextInt();

        double futureValue = principal * Math.pow(1 + annualRate, years);

        System.out.println("\n====== 投資未來價值分析 ======");
        System.out.printf("本金：%.2f 元\n", principal);
        System.out.printf("年化報酬率：%.2f%%\n", annualRate * 100);
        System.out.println("投資年數：" + years + " 年");
        System.out.printf("未來價值：約為 %.2f 元\n", futureValue);
    }

    public static void simulateRecurringInvestment(Scanner scanner) {
        System.out.println("\n====== 定期定額模擬 ======");

        System.out.print("請輸入每月投入金額（元）：");
        double monthlyInvestment = scanner.nextDouble();

        System.out.print("請輸入預期年化報酬率（例如5%輸入0.05）：");
        double annualRate = scanner.nextDouble();

        System.out.print("請輸入投資年數：");
        int years = scanner.nextInt();

        double monthlyRate = annualRate / 12;
        double totalValue = 0;
        int totalMonths = years * 12;

        for (int month = 1; month <= totalMonths; month++) {
            totalValue += monthlyInvestment;
            totalValue *= (1 + monthlyRate);

            if (month % 12 == 0) {
                int currentYear = month / 12;
                System.out.printf("第 %d 年年底帳戶總價值：約為 %.2f 元\n", currentYear, totalValue);
            }
        }

        double totalInvested = monthlyInvestment * totalMonths;
        double profit = totalValue - totalInvested;

        System.out.println("\n====== 投資模擬總結 ======");
        System.out.printf("每月投入：%.2f 元\n", monthlyInvestment);
        System.out.printf("年化報酬率：%.2f%%\n", annualRate * 100);
        System.out.println("投資年數：" + years + " 年");
        System.out.printf("總投入本金：%.2f 元\n", totalInvested);
        System.out.printf("投資獲利：%.2f 元\n", profit);
        System.out.printf("最終帳戶價值：約為 %.2f 元\n", totalValue);
    }

    public static void assessPortfolioRisk(Scanner scanner) {
        System.out.println("\n====== 投資組合評估 ======");

        double[] weights = new double[3];
        double[] returns = new double[3];

        System.out.println("請輸入三支股票的投資權重（加總須為1）：");
        for (int i = 0; i < 3; i++) {
            System.out.print("第 " + (i + 1) + " 支股票權重：");
            weights[i] = scanner.nextDouble();
        }

        System.out.println("\n請輸入三支股票的預期年化報酬率（例如5%輸入0.05）：");
        for (int i = 0; i < 3; i++) {
            System.out.print("第 " + (i + 1) + " 支股票預期報酬率：");
            returns[i] = scanner.nextDouble();
        }

        double weightSum = weights[0] + weights[1] + weights[2];
        if (Math.abs(weightSum - 1.0) > 0.001) {
            System.out.println("\n警告：權重加總必須等於1，請重新執行此功能。");
            return;
        }

        double portfolioReturn = 0;
        for (int i = 0; i < 3; i++) {
            portfolioReturn += weights[i] * returns[i];
        }

        double maxReturn = Math.max(returns[0], Math.max(returns[1], returns[2]));
        double minReturn = Math.min(returns[0], Math.min(returns[1], returns[2]));
        double riskIndicator = maxReturn - minReturn;

        String riskLevel;
        if (riskIndicator > 0.05) {
            riskLevel = "高";
        } else if (riskIndicator > 0.02) {
            riskLevel = "中";
        } else {
            riskLevel = "低";
        }

        System.out.println("\n====== 投資組合風險分析報告 ======");
        for (int i = 0; i < 3; i++) {
            System.out.printf("股票 %d：權重 = %.2f，預期報酬率 = %.2f%%\n",
                    i + 1, weights[i], returns[i] * 100);
        }
        System.out.printf("\n整體預期報酬率：%.2f%%\n", portfolioReturn * 100);
        System.out.printf("最高與最低報酬率差：%.2f%%\n", riskIndicator * 100);
        System.out.println("根據您的資產配置，您的投資風險水平為：「" + riskLevel + "」。");
    }

    public static void calculateMortgage(Scanner scanner) {
        System.out.println("\n====== 房貸計算 ======");

        System.out.print("請輸入貸款金額：");
        double loanAmount = scanner.nextDouble();

        System.out.print("請輸入貸款年數：");
        int years = scanner.nextInt();

        System.out.print("請輸入年利率(%)：");
        double annualInterestRate = scanner.nextDouble();

        double monthlyRate = annualInterestRate / 12 / 100;
        int totalMonths = years * 12;

        double monthlyPayment = (loanAmount * monthlyRate * Math.pow(1 + monthlyRate, totalMonths))
                / (Math.pow(1 + monthlyRate, totalMonths) - 1);

        double remainingBalance = loanAmount;
        double totalInterest = 0;

        System.out.printf("\n每月應付金額：%.2f 元\n", monthlyPayment);
        System.out.println("還款明細表（第一年完整，後續省略中間資料）：");
        System.out.printf("%-5s %-12s %-12s %-12s %-12s\n",
                "月數", "期初餘額", "本月利息", "償還本金", "期末餘額");

        int month = 1;

        for (; month <= 12 && month <= totalMonths; month++) {
            double interest = remainingBalance * monthlyRate;
            double principal = monthlyPayment - interest;
            double endBalance = remainingBalance - principal;

            totalInterest += interest;

            System.out.printf("%-5d %-12.2f %-12.2f %-12.2f %-12.2f\n",
                    month, remainingBalance, interest, principal, endBalance);

            remainingBalance = endBalance;
        }

        while (month <= totalMonths) {
            double interest = remainingBalance * monthlyRate;
            double principal = monthlyPayment - interest;
            remainingBalance -= principal;
            totalInterest += interest;
            month++;
        }

        if (month > 13) {
            System.out.println("...（中間月份略）");
        }

        System.out.printf("\n貸款總額：%.2f 元\n", loanAmount);
        System.out.printf("貸款總利息：%.2f 元\n", totalInterest);
        System.out.printf("總還款金額：%.2f 元\n", loanAmount + totalInterest);
    }
}
