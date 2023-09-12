public class Student {
    private Integer groupNumber;
    private String lastName;
    private String firstName;
    private String patronymic;

    public Student(Integer groupNumber, String lastName, String firstName, String patronymic) {
        this.groupNumber = groupNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }
    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    @Override
    public String toString() {
        return  "№: " + groupNumber
                + "  ФИО: " + lastName  + " "
                + firstName + " "
                +  patronymic;
    }
}
