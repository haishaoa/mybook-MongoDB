package pojo;

/**
 * @author haishao
 * @create 2020-05-20 1:24
 * @discript :
 */
public class Reader {
    private String readername;
    private String vip;
    private String phone;
    private String credit;

    public String getReadername() {
        return readername;
    }

    public void setReadername(String readername) {
        this.readername = readername;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readername='" + readername + '\'' +
                ", vip='" + vip + '\'' +
                ", phone='" + phone + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }
}
