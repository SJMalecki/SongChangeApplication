package pl.sjmprofil;

import java.util.ArrayList;

public class Album {

    private String artistName;
    private String albumTitle;
    private ArrayList<Song> albumSongList;

    public Album(String artistName, String albumTitle){
        this.artistName = artistName;
        this.albumTitle = albumTitle;
        this.albumSongList = new ArrayList<Song>();
    }

    public boolean addSongToAlbum(String title, double duration){
        if(findSong(title,duration) != null){
            System.out.println("Song is already in album song list");
            return false;
        }else{
            albumSongList.add(new Song(title, duration));
            System.out.println("New song added to " + this.albumTitle + " album: " + title + " " + duration );
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

    public Song findSong(int songNumber){
        int index = songNumber - 1;
        if(index >= 0 && index < albumSongList.size()){
            return albumSongList.get(index);
        }else{
            System.out.println("Wrong number");
            return null;
        }
    }

    public void printAlbumSongList(){
        System.out.println(albumTitle + " - " + artistName);
        if(!albumSongList.isEmpty()){
            for (int i = 0; i < albumSongList.size(); i++) {
                System.out.println((i+1) + ". " + albumSongList.get(i).getTitle() + " "
                        + albumSongList.get(i).getDuration());
            }
        }else
            System.out.println("Album is empty");
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public ArrayList<Song> getAlbumSongList() {
        return albumSongList;
    }

    public String getArtistName() {
        return artistName;
    }
}
