package p_exam;

import java.util.ArrayList;

public class Directory {
    private ArrayList<Contact> contacts;

    /**
     * Determines if the contacts list (instance variable) contains a contact with
     * the given name and phone number.
     * @param name the name of the contact
     * @param phoneNumber the phone number of the contact
     * @return true if list contains contact matching the name and phone number, otherwise false
     */
    public boolean contains(String name, String phoneNumber) {
        // TODO (about 6 lines)
        for(Contact cont: contacts) {
            if (name.equals(cont.getName()) && phoneNumber.equals(cont.getPhoneNumber())) {
                return true;
            }
            if (cont.getName().equals(name) && cont.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public static void main(String[] args) {
        Directory d = new Directory();
        // optional testing can go here
        System.out.println(d.contains("t", "1212"));
    }
}