/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

/**
 *
 * @author aluno
 */
public class Usuario {
    private int IdUser;
    private String NameUser;
    private int PermissionsUser;
    private String KeyUser;
    private boolean isActivated;
    
    public int ADM = 0;
    public int MANAGER = 1;
    public int USER = 2;

    /**
     * @return the IdUser
     */
    public int getIdUser() {
        return IdUser;
    }

    /**
     * @param IdUser the IdUser to set
     */
    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    /**
     * @return the NameUser
     */
    public String getNameUser() {
        return NameUser;
    }

    /**
     * @param NameUser the NameUser to set
     */
    public void setNameUser(String NameUser) {
        this.NameUser = NameUser;
    }

    /**
     * @return the PermissionsUser
     */
    public int getPermissionsUser() {
        return PermissionsUser;
    }

    /**
     * @param PermissionsUser the PermissionsUser to set
     */
    public void setPermissionsUser(int PermissionsUser) {
        this.PermissionsUser = PermissionsUser;
    }

    /**
     * @return the KeyUser
     */
    public String getKeyUser() {
        return KeyUser;
    }

    /**
     * @param KeyUser the KeyUser to set
     */
    public void setKeyUser(String KeyUser) {
        this.KeyUser = KeyUser;
    }

    /**
     * @return the isActivated
     */
    public boolean isIsActivated() {
        return isActivated;
    }

    /**
     * @param isActivated the isActivated to set
     */
    public void setIsActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }
    
}
