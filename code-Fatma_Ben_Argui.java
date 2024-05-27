import java.util.ArrayList;
import java.util.List;

// Interface for category abstract factory
interface CategoryAbstractFactory {
    Category createCategory();
}

// Concrete implementation of SousCategoryFactory
class SousCategoryFactory implements CategoryAbstractFactory {
    public Category createCategory() {
        return new Category();
    }
}

// Concrete implementation of CategoryFactory
class CategoryFactory implements CategoryAbstractFactory {
    public Category createCategory() {
        return new Category();
    }
}

// Class representing a category
class Category extends CategoryFactory {
    private String title;

    public void delete() {
        // Method implementation for deleting category
    }

    public void addSousCategorie(String titre) {
        // Method implementation for adding sub-categories
    }
}

// Class representing a sub-category
class SousCategory extends SousCategoryFactory {
    private String title;

    public void delete() {
        // Method implementation for deleting sub-category
    }
}

// Interface for user factory
interface UserFactory {
    void addUser();
}

// Concrete implementation of NormalUserFactory
class NormalUserFactory implements UserFactory {
    public void addUser() {
        // Method implementation for adding normal user
    }
}

// Concrete implementation of AdminUserFactory
class AdminUserFactory implements UserFactory {
    public void addUser() {
        // Method implementation for adding admin user
    }
}

// Class representing a normal user
class NormalUser extends NormalUserFactory {
    private String nom;
    private String email;
    private String pwd;

    public void manageProfile(String ProfileData) {
        // Method implementation for managing user profile
    }
}

// Class representing an admin user
class AdminUser extends AdminUserFactory {
    private String nom;
    private String pwd;

    public void delete() {
        // Method implementation for deleting admin user
    }
}

// Class representing a document
class Document {
    private String titre;
    private String filename;
    private String date;
    private String image;
    private Partenaire partenaire;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;}

    public Document createDocument(String titre, String filename, String lieu, String date, String image) {
        // Method implementation for creating a document
        return new Document();
    }

    public void publishDocument(Document document) {
        // Method implementation for publishing a document
    }
}

// Class representing a partner
class Partenaire extends NormalUser {
    private String tel;
    private String adresse;
    private String etat;

    public String getEtat() {
        return etat;
    }
    public void manageProfile(String ProfileData) {
        // Method implementation for managing partner profile
    }
}

// Class representing an actuality
class Actualité {
    private String titre;
    private String commentaire;
    private Partenaire partenaire;

    public Actualité createActualite(String titre, String commentaire) {
        // Method implementation for creating an actuality
        return new Actualité();
    }

    public void publishActualite(Actualité actualite) {
        // Method implementation for publishing an actuality
    }
}

// Class representing a comment
class Commentaire {
    private String texte;
    private NormalUser utilisateur;
    private Document document;
    // Getter pour le texte du commentaire
    public String getTexte() {
        return texte;
    }

    // Getter pour l'utilisateur ayant fait le commentaire
    public NormalUser getUtilisateur() {
        return utilisateur;
    }

    // Getter pour le document associé au commentaire
    public Document getDocument() {
        return document;
    }
}

// Classe représentant un gestionnaire de commentaires
class CommentsManager {
    private List<Commentaire> commentaires;

    public void addComment(Document document, Commentaire commentaire) {
        // Ajouter un commentaire au document
        commentaires.add(commentaire);
    }

    public void deleteComment(Commentaire commentaire) {
        // Supprimer un commentaire
        commentaires.remove(commentaire);
    }
}





// Class representing a like
class Like {
    private NormalUser user;
    private Document document;
}


class CommentaireService {

    Commentaire commentaire = new Commentaire();
    public void enregistrerCommentaire(Commentaire commentaire) throws Exception {
        if (!"actif".equals(commentaire.getDocument().getPartenaire().getEtat())) {
            throw new Exception("Vous ne pouvez pas commenter les documents de partenaires inactifs.");
        }
        // Logique pour enregistrer le commentaire
    }
}

class Main {
    public static void main(String[] args) {
        // Example usage of the classes
        CategoryAbstractFactory factory = new SousCategoryFactory();
        Category sousCategory = factory.createCategory();
        sousCategory.delete();

        UserFactory userFactory = new NormalUserFactory();
        userFactory.addUser();
    }
}
