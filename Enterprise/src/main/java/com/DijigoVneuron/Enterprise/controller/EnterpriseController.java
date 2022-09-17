package com.DijigoVneuron.Enterprise.controller;

import com.DijigoVneuron.Enterprise.Services.EmailsenderService;
import com.DijigoVneuron.Enterprise.Repository.*;
import com.DijigoVneuron.Enterprise.model.*;
import com.DijigoVneuron.Enterprise.util.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController

@CrossOrigin()
public class EnterpriseController {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DemandeRepository demandeRepository;
    @Autowired
    EnterpriseRepository enterpriseRepository;
    @Autowired
    ClientproRepository clientproRepository;
    @Autowired
    PclientRepository pclientRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    EmailsenderService emailsenderService;
    @CrossOrigin
    @PostMapping("/demnderperso")
    public String demnderperso(@RequestParam("imageid") MultipartFile file,

                               @RequestParam("nom") String nom,
                               @RequestParam("prenom") String prenom,
                               @RequestParam("mail") String mail,
                               @RequestParam("tel") String tel,
                               @RequestParam("typeid") String typeid,
                               @RequestParam("numid") String numid,
                               @RequestParam("natio") String natio,

                               @RequestParam("Rendezvous") String rendezvous,
                               @RequestParam("sla") String sla,
                               @RequestParam("datn") String datn,
                               @RequestParam("datd") String datd,
                               @RequestParam("statud") String statud,
                               @RequestParam("statur") String statur,
                               @RequestParam("type") String type) throws IOException {

        clientRepository.save(Client.builder()
                        .daten(datn)
                .nom(nom)
                .prenom(prenom)
                .mail(mail)
                .tel(tel)
                .type(type)
                .typeid(typeid)
                .numid(numid)
                .natio(natio)


                .imageid(ImageUtility.compressImage(file.getBytes())).build());
        Client client=clientRepository.findByMail(mail);
        Long x =client.getId();
        utilisateurRepository.save(Utilisateur.builder()
                .idutili(x)
                .login(mail)
                .passw(tel)
                .role("Client")
                .build());
        Utilisateur utilisateur = utilisateurRepository.findByLogin(mail);
        Long y=utilisateur.getId();

        demandeRepository.save(Demande.builder()
                        .idc(x)
                        .sla(sla)
                        .type(type)
                        .statur(statur)
                        .statud(statud)
                        .rendezvous(rendezvous)
                        .date(datd)

                .build());
emailsenderService.sendmail(mail,"Demande DigiGO","Felistation! \n Votre demande est emis avec succes \n" +
        " viellez se connecter pour complete votre demande \n " +
        "votre login est votre mail \n" +
        "votre mot de pass est votre numero telephonne \n");

        return "nere";

    }
    @CrossOrigin
    @PostMapping("/demnderpro")
    public String demnderpro(
            @RequestParam("imageid") MultipartFile file,

            @RequestParam("nom") String nom,
            @RequestParam("prenom") String prenom,
            @RequestParam("mail") String mail,
            @RequestParam("tel") String tel,
            @RequestParam("typeid") String typeid,
            @RequestParam("numid") String numid,
            @RequestParam("natio") String natio,


            @RequestParam("datn") String datn,


                              @RequestParam("repnom") String renom,
            @RequestParam("repdatn") String repdatn,
                              @RequestParam("repprenom") String reprenom,
                              @RequestParam("repmail") String remail,
                              @RequestParam("reptel") String retel,
                              @RequestParam("reptypeid") String retypeid,
                              @RequestParam("repnumid") String renumid,
                              @RequestParam("repnatio") String renatio,
                              @RequestParam("reppaysenrg") String reppaysenrg,
                              @RequestParam("Rendezvous") String rendezvous,
                              @RequestParam("sla") String sla,
                              @RequestParam("date") String date,
                              @RequestParam("statud") String statud,
                              @RequestParam("statur") String statur,
                              @RequestParam("type") String type,
                              @RequestParam("raison") String raison
                             ,@RequestParam("matricule") String matricule,
                              @RequestParam("imagerne") MultipartFile filrne,
                              @RequestParam("imagerepid") MultipartFile filrepid
                           )
            throws IOException {
        clientproRepository.save(Clientpro.builder()

                        .raison(raison)
                        .matricule(matricule)
                        .mail(mail)
                .repnom(renom)
                .repprenom(reprenom)
                .repmail(remail)
                .reptel(retel)
                .imagerepid(ImageUtility.compressImage(filrepid.getBytes()))
                .reptypeid(retypeid)
                .repnumid(renumid)
                .renatio(renatio)
                .reppaysenrg(reppaysenrg)

                .imagerne(ImageUtility.compressImage(filrne.getBytes())).build());

        Clientpro clientpro = clientproRepository.findByMail(mail);
        Long x=clientpro.getId();

        clientRepository.save(Client.builder()
                        .id_client(x)
                        .daten(datn)
                        .natio(natio)
                        .typeid(typeid)
                        .numid(numid)
                        .type("pro")
                        .mail(mail)
                        .tel(tel)
                        .prenom(prenom)
                        .nom(nom)
                        .imageid(ImageUtility.compressImage(file.getBytes()))

                .build());
        Client client = clientRepository.findByMail(mail);
        Long y=client.getId();
        utilisateurRepository.save(Utilisateur.builder()
                .idutili(y)
                .login(mail)
                .passw(tel)
                .role("Client")
                .build());
        demandeRepository.save(Demande.builder()
                        .idc(y)
                        .date(date)
                        .rendezvous(rendezvous)
                        .statud(statud)
                        .statur(statur)
                        .type(type)
                        .sla(sla)
                .build());
        emailsenderService.sendmail(mail,"Demande DigiGO","Felistation! \n Votre demande est emis avec succes \n" +
                " viellez se connecter pour complete votre demande \n " +
                "votre login est votre mail \n" +
                "votre mot de pass est votre numero telephonne \n");
        return "nere";

    }
    @CrossOrigin
    @PostMapping("/ajouter")
    public  String ajouter(
            @RequestParam("enter") String enter,
                           @RequestParam("mail") String mail,
                           @RequestParam("tel") String tel,
                           @RequestParam("sla") String sla){


        pclientRepository.save(Pclient.builder()
                        .sla(sla)
                        .identer(enter)
                        .type("pro")
                        .mail(mail).tel(tel)
                .build());


        return "ok";
    }

    @CrossOrigin
    @PostMapping("/ajouterenterprise")
    public  String ajouterenter(
            @RequestParam("enter") String enter,
            @RequestParam("mail") String mail,
            @RequestParam("tel") String tel,
            @RequestParam("nbcrtf") int nbcrtf){

        enterpriseRepository.save(Enterprise.builder()
                        .nbcrtif(nbcrtf)
                        .raison(enter)
                        .mail(mail)
                .build());
        Enterprise enterprise=enterpriseRepository.findByMail(mail);
        Long x=enterprise.getId();
        utilisateurRepository.save(Utilisateur.builder()
                        .login(mail)
                        .idutili(x)
                        .passw(tel)
                        .role("Respob2b")
                .build());

        return "ok";
    }
    @CrossOrigin
    @PostMapping("/testalreqdy")
    public String testalready(@RequestParam("mail") String mail)
    {
        if(clientRepository.findByMail(mail)==null){
            return "0";
        }
        return "1";
    }

    @CrossOrigin
    @PostMapping("/testprepaye")
    public String testpre(@RequestParam("mail") String mail)
    {
        if(pclientRepository.findByMail(mail)==null){
            return "0";
        }
        else{
            return "1";
        }
    }
    @CrossOrigin
    @PostMapping("/modifierende")
    public String modifierende(@RequestParam("rendez") String rendez,@RequestParam("id") Long id){
        Optional<Demande> demande= demandeRepository.findById(id);
        if (demande.isPresent()){
            Demande existedemande = demande.get();
            existedemande.setRendezvous(rendez);
            demandeRepository.save(existedemande);
            return "true";
        }else return "false";
    }
    @CrossOrigin
    @GetMapping ("/ppclient")
    public List<Pclient> ppclient(@RequestParam("id") Long idnt){
        Optional<Enterprise> enterprise=enterpriseRepository.findById(idnt);
        if (enterprise.isPresent()){
            Enterprise enterprise1=enterprise.get();
            String x=enterprise1.getRaison();
            List<Pclient> list=pclientRepository.findByIdenter(x);
            return list;
        }
        return null;

    }
    @CrossOrigin
    @GetMapping("/modifierstatur")
    public String modifierstatur(@RequestParam("statur") String statur,
                                 @RequestParam("id") Long id){
        Optional<Demande> demande= demandeRepository.findById(id);
        if (demande.isPresent()){
            Demande existedemande = demande.get();
            existedemande.setStatur(statur);
            demandeRepository.save(existedemande);
            return "true";
        }else return "false";

    }

    @CrossOrigin
    @PostMapping("/modifierstatud")
    public String modifierstatud(@RequestParam("statud") String statud,
                                 @RequestParam("id") Long id){
    Optional<Demande> demande= demandeRepository.findById(id);
        if (demande.isPresent()){
            Demande existedemande = demande.get();
            existedemande.setStatud(statud);
            demandeRepository.save(existedemande);
            return "true";
        }else return "false";

    }
    @CrossOrigin
    @PostMapping("/getclient")
    public Client modifierstatud(
                                 @RequestParam("mail") String mail){
       Client client=clientRepository.findByMail(mail);

        return client;

    }
    @CrossOrigin
    @PostMapping("/authentif")
    public Utilisateur authentif(@RequestParam("login") String login,
                            @RequestParam("password") String password){
        if (utilisateurRepository.findByLogin(login)!=null){
            Utilisateur utilisateur = utilisateurRepository.findByLogin(login);
            if (Objects.equals(utilisateur.getPassw(),password)){
                return utilisateur;
            }else {
    Utilisateur u=new Utilisateur();
                return u;
            }
        }else {
            Utilisateur u=new Utilisateur();
            return u;
        }
    }
   /* @PostMapping("modifierclientperso")
    public Client modifierclient(@RequestParam(""))*/
   @CrossOrigin
    @GetMapping("/alldemande")
    public List<Demande> demandes(){

       return demandeRepository.findAll();
    }
    @CrossOrigin
    @GetMapping("/demandeclient")
    public Client demandeclient(@RequestParam("idc") Long idc){
    Optional<Client> client=clientRepository.findById(idc);
        if (client.isPresent()){
            Client client1=client.get();
            return client1;
        }
        return null;
    }
    @CrossOrigin
    @GetMapping("/allEnter")
    public List<Enterprise> enterprises(){
        return enterpriseRepository.findAll();
    }
    @CrossOrigin
    @GetMapping("/allcl")
    public List<Client> allcl(){
        return clientRepository.findAll();
    }
    @CrossOrigin
    @PostMapping("/enercertif")
    public int entercertif(@RequestParam("identer") Long identer){
        Optional<Enterprise> enterprise = enterpriseRepository.findById(identer);
        if (enterprise.isPresent()){
            Enterprise existedemande = enterprise.get();
          return  existedemande.getNbcrtif();
    }return 0;
}
    @CrossOrigin
    @PostMapping("/fclient")
    public Client fclient(@RequestParam("idc") Long idc){
        Optional<Client> client = clientRepository.findById(idc);
        if (client.isPresent()){
            Client existedemande = client.get();
           existedemande.setImageid(ImageUtility.compressImage(existedemande.getImageid()));
           return existedemande;
        }return null;
    }
    @CrossOrigin
    @PostMapping("/fclientdd")
    public Client fclientdd(@RequestParam("idc") Long idc){

        Optional<Client> client = clientRepository.findById(idc);
        if (client.isPresent()){
            Client existedemande = client.get();
            existedemande.setImageid(ImageUtility.compressImage(existedemande.getImageid()));
            return existedemande;
        }return null;
    }
    @CrossOrigin
    @PostMapping("/getdd")
    public Demande getdd(@RequestParam("idc") Long idc){
        Demande demande = demandeRepository.findByIdc(idc);
        return demande;
    }
    @CrossOrigin
    @PostMapping("/ajouterenter")

    public String ajouterenter(@RequestParam("raison") String raison,
                               @RequestParam("nbcertif") int nbcertif)throws Exception{
        enterpriseRepository.save(Enterprise.builder()
                .raison(raison)
                /*.respo_b2b()*/
                .nbcrtif(nbcertif)
                .build());
        return "ok";
    }
    @CrossOrigin
    @PostMapping("/ajouterlien")

   public String ajouterlien(@RequestParam("idc") Long idc ,
                              @RequestParam("lien") String lien){
       Demande demande=demandeRepository.findByIdc(idc);



       demande.setLien(lien);
       demandeRepository.save(demande);

       Optional<Client> client = clientRepository.findById(idc);
       if (client.isPresent()){
           Client client1=client.get();
           String maili=client1.getMail();
           emailsenderService.sendmail(maili,"Apple video","Veillez se connecter pour passer votre apple video ");

       return "ok";}

   return "no";}
    @CrossOrigin
    @PostMapping("/modifierrr")
    public String modifierrr(@RequestParam("idc") Long idc, @RequestParam("rendez") String rendez)throws Exception{

            Demande demande = demandeRepository.findByIdc(idc);
            demande.setRendezvous(rendez);
            demandeRepository.save(demande);

            Optional<Client> client = clientRepository.findById(idc);
            if (client.isPresent()){
                Client client1 = client.get();
                String maili=client1.getMail();
                String nomi=client1.getNom()+" "+client1.getPrenom();
                emailsenderService.sendmail(maili,"Rendez-vous changer","Vous venez de changer votre rendez-vous a "+rendez+"\n" +
                        "veillez etre present pour passez votre renddez-vous ");
                emailsenderService.sendmail("ahmedmeh36@gmail.com","Client a changer sa rendez-vous","le client "+nomi+" a changer sa rendez-vous veillez s'adresser aux dashboard pour plus info");
            }

        return "nere";

    }
    @CrossOrigin
    @PostMapping("/ajouterpclient")
    public String ajouterpclient(@RequestParam("mail") String mail,
                                 @RequestParam("tel") String tel,
                                 @RequestParam("id_enter") String identer,
                                 @RequestParam("type") String type,
                                 @RequestParam("sla") String sla){
        pclientRepository.save(Pclient.builder()
                        .mail(mail)
                        .tel(tel)
                        .identer(identer)
                        .type(type)
                        .sla(sla)
                .build());
        return "ok";
    }
    @CrossOrigin
    @PostMapping("/modifierstd")
    public String modifierstd(@RequestParam("id") Long id,
                                 @RequestParam("std") String std){
        Optional<Demande> demande=demandeRepository.findById(id);
        if (demande.isPresent()){
            Demande demande1=demande.get();
            demande1.setStatud(std);
            demandeRepository.save(demande1);
            return "ok";
        }
        return "no";
    }
    @CrossOrigin
    @PostMapping("/modifierstr")
    public String modifierstr(@RequestParam("id") Long id,
                              @RequestParam("str") String str){
        Optional<Demande> demande=demandeRepository.findById(id);
        if (demande.isPresent()){
            Demande demande1=demande.get();
            demande1.setStatur(str);
            demandeRepository.save(demande1);
            return "ok";
        }
        return "no";
    }

    @CrossOrigin
    @GetMapping (path = "/getclientimg"/*,

            produces = MediaType.IMAGE_JPEG_VALUE*/)
    public byte[] getclientimg(@RequestParam("id") Long id
                                 ) throws IOException {
       Optional<Client> client=clientRepository.findById(id);
        if (client.isPresent()){
            Client existedemande = client.get();
         byte[] bb=ImageUtility.decompressImage(existedemande.getImageid());
        /*ByteArrayInputStream bia=new ByteArrayInputStream(bb);
        BufferedImage image = ImageIO.read(bia);*/
        return bb;}
        return null;
    }
    /*@GetMapping(
            path = ""
            value = "/get-image-with-media-type",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImageWithMediaType(@RequestParam("mail") String mail) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/com/baeldung/produceimage/image.jpg");
        return IOUtils.toByteArray(in);
    }*/
}


