package pl.sjmprofil;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private PlayList playList = new PlayList("Default playlist");

    public void firstMenu(){
        boolean quit = false;
        while(!quit){
            printFirstMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                    quit = true;
                    System.out.println("Closing application...");
                    break;
                case 1:
                    albumMenu();
                    break;
                case 2:
                    playList.addSongToAlbum();
                    break;
                case 3:
                    playList.removeAlbum();
                    break;
                case 4:
                    playList.addSongToPlaylist();
                    break;
                case 5:
                    playList.printPlaylist();
                    break;
            }
        }
    }

    public void albumMenu(){
        boolean quit = false;
        ;

        while(!quit){
            printAlbumMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                    quit = true; break;
                case 1:
                    System.out.println("Enter artist name");
                    String artist = scanner.nextLine();
                    System.out.println("Enter Title");
                    String albumTitle = scanner.nextLine();
                    playList.createNewAlbum(artist, albumTitle);
                    break;
                case 2:
                    playList.addSongToAlbum(); break;
                case 3:
                    playList.removeAlbum(); break;
                case 4:
                    if(playList.printAlbumList()) {
                        System.out.println("Choose album");
                        int albumChoice = scanner.nextInt();
                        scanner.nextLine();
                        Album album = playList.findAlbum(albumChoice);
                        if(album != null){
                            album.removeSong();
                        }
                    }
                    break;

            }
        }

    }

    public void printAlbumMenu(){
        System.out.println("\nPress\n" +
                "0 - To return\n" +
                "1 - To create new album\n" +
                "2 - To add song to album\n" +
                "3 - To remove album\n" +
                "4 - To remove song from album\n");
    }

    public void printFirstMenu(){
        System.out.println("\nPress\n" +
                "1 - To enter album menu\n" +
                "2 - To add song to album \n" +
                "3 - To remove album\n" +
                "4 - To add song to playlist\n" +
                "5 - To show playlist tracks\n" +
                "0 - To quit\n" +
                "Chose: ");
    }

    public void addTestAlbumsToPlaylist(){
        playList.createNewAlbum("Kimi Rikkonen", "Winner takes it all");
        playList.findAlbum("Kimi Rikkonen", "Winner takes it all")
                .addSongToAlbum("Race", 6.35);
        playList.findAlbum("Kimi Rikkonen", "Winner takes it all")
                .addSongToAlbum("Coutdown to the start", 2.59);
        playList.findAlbum("Kimi Rikkonen", "Winner takes it all")
                .addSongToAlbum("Unstoppable", 4.51);
        playList.findAlbum("Kimi Rikkonen", "Winner takes it all")
                .addSongToAlbum("Checkered Flag", 2.23);
        System.out.println();
        playList.createNewAlbum("Lewis Hammilton", "Beat the time");
        playList.findAlbum(2).addSongToAlbum("Engine on", 1.56);
        playList.findAlbum(2).addSongToAlbum("Fuel vapors", 3.21);
    }


}
