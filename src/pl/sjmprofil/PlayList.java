package pl.sjmprofil;

import java.util.ArrayList;

public class PlayList {

    private String listName;
    private ArrayList<Album> albumList;

    public PlayList(String listName) {
        this.listName = listName;
        this.albumList = new ArrayList<Album>();
    }

    public boolean createNewAlbum(String artistName, String albumTitle){
        if(findAlbum(albumTitle, artistName) == null){
            albumList.add(new Album(artistName,albumTitle));
            System.out.println("New album: " + albumTitle + " by " + artistName + " has been created");
            return true;
        }else{
            System.out.println("Album already exists");
            return false;
        }
    }

    public Album findAlbum(String artistName, String albumTitle){
        for (int i = 0; i < albumList.size(); i++) {
            if(albumList.get(i).getArtistName().equals(artistName)
                    && (albumList.get(i).getAlbumTitle().equals(albumTitle))){
                return albumList.get(i);
            }
        }
        return null;
    }

    public Album findAlbum(int albumNumber){
        int index = albumNumber - 1;
        if(index >= 0 && index < albumList.size()){
            return albumList.get(index);
        }else{
            System.out.println("Wrong number");
            return null;
        }
    }

    public void printAlbumList(){
        if(!albumList.isEmpty()){
            for (int i = 0; i < albumList.size(); i++) {
                System.out.println((i+1) + ". " + albumList.get(i).getArtistName() + " "
                        + albumList.get(i).getAlbumTitle());
            }
        }else{
            System.out.println("List of albums is empty");
        }
    }


    public String getListName() {
        return listName;
    }
}
