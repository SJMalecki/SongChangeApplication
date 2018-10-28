package pl.sjmprofil;

import java.util.ArrayList;

public class Album {

    private String name;
    private ArrayList<Song> albumSongList;

    public Album(String name){
        this.name = name;
        this.albumSongList = new ArrayList<Song>();
    }

    public boolean addSongToAlbum(String title, double duration){
        if(findSong(title,duration) == null){
            System.out.println("Song is already in album song list");
            return false;
        }else{
            albumSongList.add(new Song(title, duration));
            System.out.println("New song added to album \"" + this.name + "\" :" + title + " " + duration );
            return true;
        }
    }

    public Song findSong(String title, double duration){
        for (int i = 0; i < albumSongList.size(); i++) {
            if((albumSongList.get(i).getTitle().equals(title)) && (albumSongList.get(i).getDuration() == duration)){
                return albumSongList.get(i);
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getAlbumSongList() {
        return albumSongList;
    }
}
