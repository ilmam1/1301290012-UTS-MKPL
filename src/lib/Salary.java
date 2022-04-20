package lib;

public class Salary extends Employee {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public Salary(Employee employee) {
        super(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getAddress(),
                employee.getIdNumber(), employee.getYearJoined(), employee.getMonthJoined(), employee.getDayJoined(),
                employee.getForeigner(), employee.getGender());
    }

    public void setMonthlySalary(int grade) {
        if (grade == 1) {
            monthlySalary = 3000000;
            if (salaryOfForeiger(monthlySalary)) {
                monthlySalary = (int) (3000000 * 1.5);
            }
        } else if (grade == 2) {
            monthlySalary = 5000000;
            if (salaryOfForeiger(monthlySalary)) {
                monthlySalary = (int) (3000000 * 1.5);
            }
        } else if (grade == 3) {
            monthlySalary = 7000000;
            if (salaryOfForeiger(monthlySalary)) {
                monthlySalary = (int) (3000000 * 1.5);
            }
        }
    }

    public void salaryOfForeiger(int monthlySalary) {
        double percent = monthlySalary * 1.5;

        if (super.getForeigner()) {
            monthlySalary = (int) (monthlySalary + percent);
        }
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public int getMonthSalary() {
        return monthlySalary;
    }

}
