package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String address;
	private String idNumber;
	private LocalDate yearJoined;
	private LocalDate monthJoined;
	private LocalDate dayJoined;
	private int monthWorkingInYear;

	private boolean isForeigner;
	private Gender gender;

	private enum Gender {
		laki_laki,
		perempuan
	} // true = Laki-laki, false = Perempuan

	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;

	public Employee(String employeeId, String firstName, String lastName, String address, String idNumber,
			LocalDate yearJoined, LocalDate monthJoined, LocalDate dayJoined, boolean isForeigner, Gender gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.idNumber = idNumber;
		this.yearJoined = yearJoined;
		this.monthJoined = monthJoined;
		this.dayJoined = dayJoined;
		this.isForeigner = isForeigner;
		this.gender = gender;

		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}

	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya
	 * (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3:
	 * 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	public boolean getForeigner() {
		return isForeigner;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public Gender getGender() {
		return gender;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public LocalDate getYearJoined() {
		return yearJoined;
	}

	public LocalDate getMonthJoined() {
		return monthJoined;
	}

	public LocalDate getDayJoined() {
		return dayJoined;
	}

	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}

	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}

	public int getAnnualIncomeTax() {

		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();

		if (date == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined.getMonthValue();
		} else {
			monthWorkingInYear = 12;
		}

		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible,
				spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
