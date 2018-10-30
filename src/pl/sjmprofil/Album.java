package pl.sjmprofil;

import java.util.ArrayList;
import java.util.Scanner;

public class Album {

    private String artistName;
    private String albumTitle;
    private ArrayList<Song> albumSongList;

    private Scanner scanner = new Scanner(System.in);

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
            System.out.println("New song added to " + this.getArtistName() + " - " + this.albumTitle + " album: "
                    + title + " " + duration );
            return true;
        }
    }

    public boolean removeSong(){
        if(printAlbumSongList()){
            System.out.println("Choose song to remove");
            int songNumber = scanner.nextInt();
            scanner.nextLine();
            Song song = findSong(songNumber);
            if(song != null){
                System.out.println("Removing " + song.getTitle() + " " + song.getDuration());
                albumSongList.remove(song);
                return true;
            }
        }
        return false;
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

    public boolean printAlbumSongList(){
        System.out.println(albumTitle + " - " + artistName);
        if(!albumSongList.isEmpty()){
            for (int i = 0; i < albumSongList.size(); i++) {
                System.out.println((i+1) + ". " + albumSongList.get(i).getTitle() + " "
                        + albumSongList.get(i).getDuration());
            }
            return true;
        }else
            System.out.println("Album is empty");
        return false;
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
