package pl.sjmprofil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class PlayList {

    private Scanner scanner = new Scanner(System.in);

    private String listName;
    private ArrayList<Album> albumList;
    private LinkedList<Song> userPlayList;

    public PlayList(String listName) {
        this.listName = listName;
        this.albumList = new ArrayList<Album>();
        this.userPlayList = new LinkedList<Song>();
    }

    public boolean removeAlbum(){
        if(printAlbumList()){
            System.out.println("Chose album to remove: ");
            int albumNumber = scanner.nextInt();
            scanner.nextLine();
            Album album = findAlbum(albumNumber);
            if(album != null){
                System.out.println("Removing " + album.getArtistName() + " " + album.getAlbumTitle());
                albumList.remove(album);
                return true;
            }
        }
        return false;
    }

    public boolean addSongToPlaylist() {
        if (printAlbumList()) {
            System.out.println("Chose album: ");
            int albumNumber = scanner.nextInt();
            scanner.nextLine();
            Album album = findAlbum(albumNumber);
            if (album != null && album.printAlbumSongList()) {
                System.out.println("Chose song: ");
                int songNumber = scanner.nextInt();
                scanner.nextLine();
                Song song = album.findSong(songNumber);
                userPlayList.add(song);
                System.out.println(song.getTitle() + " " + song.getDuration() + " added");
                return true;
            }
        }
        return false;
    }

    public boolean printPlaylist(){
        if (!userPlayList.isEmpty()) {
            for (int i = 0; i < userPlayList.size(); i++) {
                System.out.println((i + 1) + ". " + userPlayList.get(i).getTitle() + " "
                        + userPlayList.get(i).getDuration());
            }
            return true;
        } else {
            System.out.println("Playlist is empty");
            return false;
        }
    }

    public boolean addSongToAlbum(){
        if(printAlbumList()){
            System.out.println("Chose album: ");
            int albumNumber = scanner.nextInt();
            scanner.nextLine();
            Album album = findAlbum(albumNumber);
            if(album != null){
                System.out.println("Add song - Enter song name");
                String songName = scanner.nextLine();
                System.out.println("Add song duration (example: 3,56)");
                double songDuration = scanner.nextDouble();
                album.addSongToAlbum(songName,songDuration);
            }
        }

        return false;
    }

    public boolean createNewAlbum(String artistName, String albumTitle) {
        if (findAlbum(albumTitle, artistName) == null) {
            albumList.add(new Album(artistName, albumTitle));
            System.out.println("New album: " + albumTitle + " by " + artistName + " has been created");
            return true;
        } else {
            System.out.println("Album already exists");
            return false;
        }
    }

    public Album findAlbum(String artistName, String albumTitle) {
        for (int i = 0; i < albumList.size(); i++) {
            if (albumList.get(i).getArtistName().equals(artistName)
                    && (albumList.get(i).getAlbumTitle().equals(albumTitle))) {
                return albumList.get(i);
            }
        }
        return null;
    }

    public Album findAlbum(int albumNumber) {
        int index = albumNumber - 1;
        if (index >= 0 && index < albumList.size()) {
            return albumList.get(index);
        } else {
            System.out.println("Wrong number");
            return null;
        }
    }

    public boolean printAlbumList() {
        if (!albumList.isEmpty()) {
            for (int i = 0; i < albumList.size(); i++) {
                System.out.println((i + 1) + ". " + albumList.get(i).getArtistName() + " "
                        + albumList.get(i).getAlbumTitle());
            }
            return true;
        } else {
            System.out.println("List of albums is empty");
            return false;
        }
    }

    public String getListName() {
        return listName;
    }

    public LinkedList<Song> getUserPlayList() {
        return userPlayList;
    }
}
