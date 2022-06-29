package cn.edu.guet.bean;

public class Loopimg {
    public String getLoopimgid() {
        return loopimgid;
    }

    public void setLoopimgid(String loopimgid) {
        this.loopimgid = loopimgid;
    }

    public String getLoopimgurl() {
        return loopimgurl;
    }

    public void setLoopimgurl(String loopimgurl) {
        this.loopimgurl = loopimgurl;
    }

    @Override
    public String toString() {
        return "Loopimg{" +
                "loopimgid='" + loopimgid + '\'' +
                ", loopimgurl='" + loopimgurl + '\'' +
                '}';
    }

    private String loopimgid;
    private String loopimgurl;
}
