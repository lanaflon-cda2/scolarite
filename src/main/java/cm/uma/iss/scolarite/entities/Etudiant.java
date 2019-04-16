package cm.uma.iss.scolarite.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author ngnawen<sngnawen@yahoo.fr>
 */
@Entity(name = "etudiant")
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_etudiant")
    private Long id_etudiant;
    @Column(name = "matricule", nullable = false, unique = true)
    private String matricule;
    @Column(name = "numero")
    private int numero;
    @Column(name = "nom", nullable = true)
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "genre")
    private String genre;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "date_naiss")
    private String date_naiss;
    @Column(name = "lieu_naiss")
    private String lieu_naiss;
    @Column(name = "categorie")
    private String categorie;
    @Column(name = "statut_matri")
    private String statut_matri;
    @Column(name = "tuteur")
    private String tuteur;
    @Column(name = "adresse_tuteur")
    private String adresse_tuteur;
    @Column(name = "observation")
    private String observation;
    @ManyToOne
    @JoinColumn(name = "id_paysOrigine")
    private PaysOrigine paysOrigine;
    @ManyToOne
    @JoinColumn(name = "id_regionOrigine")
    private RegionOrigine regionOrigine;
    @ManyToOne
    @JoinColumn(name = "id_departementOrigine")
    private DepartementOrigine departementOrigine;
    @ManyToOne
    @JoinColumn(name = "id_arrondissementOrigine")
    private ArrondissementOrigine arrondissementOrigine;
    // les annotations one-to-many
    @OneToMany(mappedBy = "etudiant")
    private List<Paiement> paiementList;
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private List<Inscription> inscriptionList;
    @OneToMany(mappedBy = "etudiant")
    private List<RetraitRetourDoc> retraitRetourDocs;
//    @ManyToMany
//    @JoinTable(name = "etudiant_doc",
//            joinColumns = @JoinColumn(name = "etudiantId"),
//            inverseJoinColumns =@JoinColumn(name="documentId"))
//        private List<Documents> documentList;
    //les constructeurs


    public Etudiant() {
    }

    public List<RetraitRetourDoc> getRetraitRetourDocs() {
        return retraitRetourDocs;
    }

    public void setRetraitRetourDocs(List<RetraitRetourDoc> retraitRetourDocs) {
        this.retraitRetourDocs = retraitRetourDocs;
    }

    //getters and setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public PaysOrigine getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(PaysOrigine paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    public RegionOrigine getRegionOrigine() {
        return regionOrigine;
    }

    public void setRegionOrigine(RegionOrigine regionOrigine) {
        this.regionOrigine = regionOrigine;
    }

    public DepartementOrigine getDepartementOrigine() {
        return departementOrigine;
    }

    public void setDepartementOrigine(DepartementOrigine departementOrigine) {
        this.departementOrigine = departementOrigine;
    }

    public ArrondissementOrigine getArrondissementOrigine() {
        return arrondissementOrigine;
    }

    public void setArrondissementOrigine(ArrondissementOrigine arrondissementOrigine) {
        this.arrondissementOrigine = arrondissementOrigine;
    }

    public Long getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(Long id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getLieu_naiss() {
        return lieu_naiss;
    }

    public void setLieu_naiss(String lieu_naiss) {
        this.lieu_naiss = lieu_naiss;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStatut_matri() {
        return statut_matri;
    }

    public void setStatut_matri(String statut_matri) {
        this.statut_matri = statut_matri;
    }

    public String getTuteur() {
        return tuteur;
    }

    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }

    public String getAdresse_tuteur() {
        return adresse_tuteur;
    }

    public void setAdresse_tuteur(String adresse_tuteur) {
        this.adresse_tuteur = adresse_tuteur;
    }

    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }

    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

   

    
}