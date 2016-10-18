/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifeLine.orm.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anoop
 */
@Entity
@Table(name = "Donation_Camp_Volenteer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DonationCampVolenteer.findAll", query = "SELECT d FROM DonationCampVolenteer d")
    , @NamedQuery(name = "DonationCampVolenteer.findByUserID", query = "SELECT d FROM DonationCampVolenteer d WHERE d.donationCampVolenteerPK.userID = :userID")
    , @NamedQuery(name = "DonationCampVolenteer.findByCampID", query = "SELECT d FROM DonationCampVolenteer d WHERE d.donationCampVolenteerPK.campID = :campID")
    , @NamedQuery(name = "DonationCampVolenteer.findByRequestStatus", query = "SELECT d FROM DonationCampVolenteer d WHERE d.requestStatus = :requestStatus")})
public class DonationCampVolenteer implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DonationCampVolenteerPK donationCampVolenteerPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Request_Status")
    private String requestStatus;

    public DonationCampVolenteer() {
    }

    public DonationCampVolenteer(DonationCampVolenteerPK donationCampVolenteerPK) {
        this.donationCampVolenteerPK = donationCampVolenteerPK;
    }

    public DonationCampVolenteer(DonationCampVolenteerPK donationCampVolenteerPK, String requestStatus) {
        this.donationCampVolenteerPK = donationCampVolenteerPK;
        this.requestStatus = requestStatus;
    }

    public DonationCampVolenteer(int userID, int campID) {
        this.donationCampVolenteerPK = new DonationCampVolenteerPK(userID, campID);
    }

    public DonationCampVolenteerPK getDonationCampVolenteerPK() {
        return donationCampVolenteerPK;
    }

    public void setDonationCampVolenteerPK(DonationCampVolenteerPK donationCampVolenteerPK) {
        this.donationCampVolenteerPK = donationCampVolenteerPK;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donationCampVolenteerPK != null ? donationCampVolenteerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonationCampVolenteer)) {
            return false;
        }
        DonationCampVolenteer other = (DonationCampVolenteer) object;
        if ((this.donationCampVolenteerPK == null && other.donationCampVolenteerPK != null) || (this.donationCampVolenteerPK != null && !this.donationCampVolenteerPK.equals(other.donationCampVolenteerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DonationCampVolenteer[ donationCampVolenteerPK=" + donationCampVolenteerPK + " ]";
    }
    
}
