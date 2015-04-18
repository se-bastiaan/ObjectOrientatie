package webwinkel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author Sébastiaan Versteeg (s4459636)
 */
public class Winkel {

    private List<Gebruiker> gebruikers;
    private List<Artikel> producten;
    private Scanner scanner;
    private String ingelogdeGebruiker;

    /**
     * Constructor laadt gegevens uit bestanden in variabelen
     */
    public Winkel() {
        scanner = new Scanner(System.in);
        File artFile = new File("WinkelArtikelen.data");
        File gebFile = new File("WinkelGebruikers.data");
        if (artFile.exists()) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(artFile));
                producten = (List<Artikel>) in.readObject();
                in.close();
            } catch (IOException iOException) {
                System.out.println(iOException);
                System.exit(1);
            } catch (ClassNotFoundException classNotFoundException) {
                System.out.println(classNotFoundException);
                System.exit(1);
            }
        } else {
            producten = new ArrayList<Artikel>();
        }

        if (gebFile.exists()) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(gebFile));
                gebruikers = (List<Gebruiker>) in.readObject();
                in.close();
            } catch (IOException iOException) {
                System.out.println(iOException);
                System.exit(1);
            } catch (ClassNotFoundException classNotFoundException) {
                System.out.println(classNotFoundException);
                System.exit(1);
            }
        } else {
            gebruikers = new ArrayList<Gebruiker>();
        }
    }

    /**
     * Basisberichten generator
     */
    public void init() {
        Boolean running = true;

        System.out.println("Type 'login' als je wilt inloggen of 'registeren' als je je wilt registreren");
        System.out.println("Om het programma te sluiten kun je op elk moment 'sluit' typen.");

        while(running) {
            if(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if(line.equals("sluit")) {
                    running = false;
                    return;
                }

                if(ingelogdeGebruiker == null) {
                    switch (line) {
                        case "registeren":
                            registeren();
                            System.out.println("Type 'login' als je wilt inloggen of 'registeren' als je je wilt registreren");
                            System.out.println("Om het programma te sluiten kun je op elk moment 'sluit' typen.");
                            break;
                        case "login":
                            login();
                            if (ingelogdeGebruiker != null) {
                                ListIterator<Artikel> iterator = producten.listIterator();
                                while(iterator.hasNext()) {
                                    Artikel art = iterator.next();
                                    if(art.getGebruiker().equals(ingelogdeGebruiker) && art.getKoper() != null) {
                                        System.out.println(art.getKoper() + " heeft je product " + art.getNaam() + " gekocht. Neem contact op voor de afhandeling.");
                                        iterator.remove();
                                    }
                                }
                                System.out.println("Type 'toon' als je artikelen wilt bekijken of 'verkoop' als je je iets wilt verkopen");
                                System.out.println("Om het programma te sluiten kun je op elk moment 'sluit' typen.");
                                break;
                            }
                        default:
                            System.out.println("Type 'login' als je wilt inloggen of 'registeren' als je je wilt registreren");
                            System.out.println("Om het programma te sluiten kun je op elk moment 'sluit' typen.");
                            break;
                    }
                } else {
                    switch (line) {
                        case "toon":
                            toonArtikelen();
                            System.out.println("Type 'toon' als je artikelen wilt bekijken of 'verkoop' als je je iets wilt verkopen");
                            System.out.println("Om het programma te sluiten kun je op elk moment 'sluit' typen.");
                            break;
                        case "verkoop":
                            addArtikel();
                        default:
                            System.out.println("Type 'toon' als je artikelen wilt bekijken of 'verkoop' als je je iets wilt verkopen");
                            System.out.println("Om het programma te sluiten kun je op elk moment 'sluit' typen.");
                            break;
                    }
                }
            }
        }
    }

    /**
     * Registratie
     */
    public void registeren() {
        String username = null;
        Boolean goodUser = false;
        System.out.println("Wat wil je als gebruikersnaam?");
        while(!goodUser) {
            if(scanner.hasNextLine()) {
                username = scanner.nextLine();
                Boolean found = false;
                for (Gebruiker g : gebruikers) {
                    if (g.getUserId().equals(username)) {
                        found = true;
                        break;
                    }
                }
                if(found) {
                    System.out.println("Deze gebruikersnaam is al bezet, kies een andere");
                    System.out.println("Wat wil je als gebruikersnaam?");
                } else {
                    goodUser = true;
                }
            }
        }

        System.out.println("Wat wil je als wachtwoord?");
        while(!scanner.hasNextLine()) { }
        String password = scanner.nextLine();
        Gebruiker gebruiker = new Gebruiker(username, password);

        gebruikers.add(gebruiker);
        System.out.println("Je bent nu geregisteerd. Je kunt nu inloggen.");
    }

    /**
     * Artikelen toevoegen door gebruiker
     */
    public void addArtikel() {
        System.out.println("Wat wil je verkopen?");
        while(!scanner.hasNextLine()) { }
        String naam = scanner.nextLine();
        System.out.println("Geef een omschrijving");
        while(!scanner.hasNextLine()) { }
        String omschrijving = scanner.nextLine();
        System.out.println("Wat wil je ervoor hebben? (in €)");
        while(!scanner.hasNextLine()) { }
        String prijs = scanner.nextLine();
        Artikel artikel = new Artikel(naam, omschrijving, prijs, ingelogdeGebruiker);
        producten.add(artikel);
        System.out.println("Het artikel is toegevoegd aan de database.");
    }

    public boolean login() {
        System.out.println("Wat is je gebruikersnaam?");
        while(!scanner.hasNextLine()) { }
        String username = scanner.nextLine();
        System.out.println("Wat is je wachtwoord?");
        while(!scanner.hasNextLine()) { }
        String password = scanner.nextLine();

        for(Gebruiker g : gebruikers) {
            if(g.getUserId().equals(username) && g.getPassword().equals(password)) {
                ingelogdeGebruiker = username;
                System.out.println("Je bent succesvol ingelogd.");
                return true;
            }
        }

        System.out.println("Je gegevens zijn incorrect.");
        return false;
    }

    public void sluit() {
        System.out.println("De winkel wordt nu gesloten.");

        File artFile = new File("WinkelArtikelen.data");
        File gebFile = new File("WinkelGebruikers.data");

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(artFile));
            out.writeObject(producten);
            out.close();
        } catch (IOException iOException) {
            System.out.println(iOException);
            System.exit(1);
        }

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(gebFile));
            out.writeObject(gebruikers);
            out.close();
        } catch (IOException iOException) {
            System.out.println(iOException);
            System.exit(1);
        }
    }

    public void toonArtikelen() {
        Boolean busy = true;
        int i = 0;
        for (Artikel art : producten) {
            if(art.getKoper() == null)
                System.out.println(i + ") ---- " + art.getNaam() + " --- " + art.getOmschrijving() + " -- €" + art.getPrijs() + " -- door: " + art.getGebruiker());
        }

        if(producten.size() <= 0) {
            System.out.println("Er zijn nog geen artikelen.");
            return;
        }

        System.out.println("Type 'koop #nr' als je een artikel wilt kopen of 'terug' als je terug wilt naar het hoofdmenu");
        while(busy) {
            if(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.equals("terug")) {
                    busy = false;
                } else if(line.startsWith("koop ")) {
                    String nr = line.substring(5, line.length());
                    Integer item = Integer.parseInt(nr);
                    Artikel artikel = producten.get(item);
                    if (artikel.getGebruiker().equals(ingelogdeGebruiker)) {
                        System.out.println("Je kunt je eigen product niet kopen!");
                    }
                    artikel.setKoper(ingelogdeGebruiker);
                    System.out.println("Hoera! Je het product " + artikel.getNaam() + " gekocht. De verkoper zal zo snel mogelijk contact opnemen.");
                    System.out.println("Type 'koop #nr' als je een artikel wilt kopen of 'terug' als je terug wilt naar het hoofdmenu");
                } else {
                    System.out.println("Type 'koop #nr' als je een artikel wilt kopen of 'terug' als je terug wilt naar het hoofdmenu");
                }
            }
        }



    }
}
