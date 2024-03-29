/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.harena.tpcustomerapplicatioln.jsf;

import fr.harena.tpcustomerapplicatioln.ejb.CustomerManager;
import fr.harena.tpcustomerapplicatioln.ejb.DiscountManager;
import fr.harena.tpcustomerapplicatioln.entities.Customer;
import fr.harena.tpcustomerapplicatioln.entities.Discount;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author haren
 */
@Named(value = "customerDetailsBean")  
@ViewScoped
public class CustomerDetailsBean implements Serializable {

    private int idCustomer;
    private Customer customer;
    private List<Discount> discounts;

    @EJB
    private CustomerManager customerManager;
    
    @EJB
    private DiscountManager discountManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Retourne les détails du client courant (contenu dans l'attribut customer
     * de cette classe).
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Action handler - met à jour dans la base de données les données du client
     * contenu dans la variable d'instance customer.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer (sera expliqué dans le cours).
        customer = customerManager.update(customer);
        return "customerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }
     
    public List<Discount> getDiscounts() {
        discounts = discountManager.getAllDiscounts();
        System.out.println(discounts.size());
        return discounts;
   }
}
