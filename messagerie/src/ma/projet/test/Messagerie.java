/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;


import java.util.Date;

import ma.projet.beans.Employe;
import ma.projet.beans.Message;
import ma.projet.service.EmployeService;
import ma.projet.service.MessageService;
import ma.projet.dao.IDao;

/**
 *
 * @author pc
 */
public class Messagerie {
    public static void main(String[] args) {
        //test Employe
        EmployeService es = new EmployeService();
      es.create(new Employe("LACHGAR","Mohamed"));
       es.create(new Employe("RAMI","ALI"));
        es.create(new Employe("SAFI","Fatima"));
         
        Employe e =es.findById(3);
         if (e != null){
             e.setNom("ALAOUI");
             e.setPrenom("Manale");
            es.update(e);
       
         es.delete(es.findById(2));
         for(Employe emp : es.findAll())
             System.out.println(""+emp.getNom());
       // test message
       
         MessageService ms = new MessageService();
         
         ms.create(new Message("Reunion","Reunion de fin d'annee", new Date(),es.findById(1),es.findById(2)));
          ms.create(new Message("Reunion","Reunion de fin d'annee", new Date(),es.findById(1),es.findById(3)));
           ms.create(new Message("Stage","Stage a Marrakesh", new Date(),es.findById(1),es.findById(2)));
         
           for(Message m: ms.findAll()){
               if(m.getEmpRecepteur().getId() == 3)
                   System.out.println(""+m.getSujet());
           }
    }
    }
}
    

