package cn.zknu.l_app.bean;

/**
 * Created by Administrator on 2018\4\21 0021.
 */

public class Video {
    private int id;
    private String name;
    private String url;
    private String videoThumbUrl;
    public Video(int id, String name, String url,String videoThumbUrl) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.videoThumbUrl=videoThumbUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getVideoThumbUrl() {
        return videoThumbUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVideoThumbUrl(String videoThumbUrl) {
        this.videoThumbUrl = videoThumbUrl;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", videoThumbUrl='" + videoThumbUrl + '\'' +
                '}';
    }
}
