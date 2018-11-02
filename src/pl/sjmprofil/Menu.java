package pl.sjmprofil;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private PlayList playList = new PlayList("Default playlist");

    public void firstMenu() {
        boolean quit = false;
        while (!quit) {
            printFirstMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    System.out.println("Closing application...");
                    break;
                case 1:
                    albumMenu();
                    break;
                case 2:
                    playList.addSongToPlaylist();
                    break;
                case 3:
                    playList.printPlaylist();
                    break;
                case 4:
                    playlistMenu(playList.getUserPlayList());
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }

    public void albumMenu() {
        boolean quit = false;

        while (!quit) {
            printAlbumMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    creatingNewAlbumFromMenu();
                    break;
                case 2:
                    playList.addSongToAlbum();
                    break;
                case 3:
                    playList.removeAlbum();
                    break;
                case 4:
                    removeSongFromMenu();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public void playlistMenu(LinkedList<Song> playlistOfSongs) {
        ListIterator<Song> listIterator = playlistOfSongs.listIterator();

        if (playlistOfSongs.isEmpty()) {
            System.out.println("Playlist is empty");
            return;
        } else {
            System.out.println("Currently playing: " + listIterator.next().getTitle());
        }

        boolean goingForward = true;
        boolean quit = false;

        while (!quit) {
            printPlaylistMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }

                    if (listIterator.hasNext()) {
                        System.out.println("Now playing: " + listIterator.next().getTitle());
                    } else {
                        System.out.println("Reached end of list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }

                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing: " + listIterator.previous().getTitle());
                    }else{
                        System.out.println("Reached beginning of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    playList.printPlaylist();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }

        }


    }

    public void creatingNewAlbumFromMenu() {
        System.out.println("Enter artist name");
        String artist = scanner.nextLine();
        System.out.println("Enter Title");
        String albumTitle = scanner.nextLine();
        playList.createNewAlbum(artist, albumTitle);
    }

    public boolean removeSongFromMenu() {
        if (playList.printAlbumList()) {
            System.out.println("Choose album");
            int albumChoice = scanner.nextInt();
            scanner.nextLine();
            Album album = playList.findAlbum(albumChoice);
            if (album != null) {
                album.removeSong();
                return true;
            }
        }
        return false;
    }

    public void printPlaylistMenu() {
        System.out.println("\nPress\n" +
                "0 - To return\n" +
                "1 - To go to next song\n" +
                "2 - To go to previous song\n" +
                "3 - To print playlist\n" +
                "Chose: ");
    }

    public void printAlbumMenu() {
        System.out.println("\nPress\n" +
                "0 - To return\n" +
                "1 - To create new album\n" +
                "2 - To add song to album\n" +
                "3 - To remove album\n" +
                "4 - To remove song from album\n");
    }

    public void printFirstMenu() {
        System.out.println("\nPress\n" +
                "1 - To enter album menu\n" +
                "2 - To add song to playlist\n" +
                "3 - To show playlist tracks\n" +
                "4 - To enter playlist menu\n" +
                "0 - To quit\n" +
                "Chose: ");
    }

    public void addTestAlbumsToPlaylist() {
        playList.createNewAlbum("Kimi Rikkonen", "Winner takes it all");
        playList.findAlbum("Kimi Rikkonen", "Winner takes it all")
                .addSongToAlbum("Race", 6.35);
        playList.findAlbum("Kimi Rikkonen", "Winner takes it all")
                .addSongToAlbum("Countdown to the start", 2.59);
        playList.findAlbum("Kimi Rikkonen", "Winner takes it all")
                .addSongToAlbum("Unstoppable", 4.51);
        playList.findAlbum("Kimi Rikkonen", "Winner takes it all")
                .addSongToAlbum("Checkered Flag", 2.23);
        System.out.println();
        playList.createNewAlbum("Lewis Hammilton", "Beat the time");
        playList.findAlbum(2).addSongToAlbum("Engine on", 1.56);
        playList.findAlbum(2).addSongToAlbum("Fuel vapors", 3.21);
        playList.addSongToPlaylist(1, 1);
        playList.addSongToPlaylist(1, 2);
        playList.addSongToPlaylist(1, 3);
        playList.addSongToPlaylist(2, 1);
        playList.addSongToPlaylist(2, 2);
    }

}
