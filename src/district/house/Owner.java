package district.house;

import java.time.LocalDate;

public class Owner {

    private String name;
    private String email;
    private String phone;
    private LocalDate memberSince;

    public Owner(String name, String email, String phone, LocalDate memberSince) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.memberSince = memberSince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(LocalDate memberSince) {
        this.memberSince = memberSince;
    }

    public String ownerInfo() {
        return "Owner: " + name + " | Email: " + email + " | Member since: " + memberSince;
    }
}