public class MyFile {
    private int id;
    private String name;
    private byte[] data;
    private String fileExtension;


    public MyFile(int id, String name, byte[] data, String fileExtension) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.fileExtension = fileExtension;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setData(byte[] data){
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public void setFileExtension(String fileExtension){
       this.fileExtension = fileExtension;
    }

    public String getFileExtension() {
        return fileExtension;
    }
}
