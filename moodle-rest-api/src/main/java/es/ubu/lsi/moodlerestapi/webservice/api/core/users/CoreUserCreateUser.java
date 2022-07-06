package es.ubu.lsi.moodlerestapi.webservice.api.core.users;

import es.ubu.lsi.moodlerestapi.webservice.webservices.WSFunctionAbstract;
import es.ubu.lsi.moodlerestapi.webservice.webservices.WSFunctionEnum;

import java.util.ArrayList;
import java.util.List;

public class CoreUserCreateUser extends WSFunctionAbstract {

    private Integer createpassword = 0;
    private String auth;

    private String email;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String phone2;
    private List<CustomField> customfields = new ArrayList<>();
    private List<CustomField> preferences = new ArrayList<>();

    private String city;

    private String country;
    private Integer maildisplay;

    private String timezone;
    private String description;
    private String firstnamephonetic;
    private String lastnamephonetic;
    private String middlename;
    private String alternatename;
    private String interests;
    private String url;
    private String icq;
    private String skype;
    private String aim;
    private String yahoo;
    private String msn;
    private String idnumber;
    private String institution;
    private String department;
    private String phone1;
    private String address;
    private String lang;
    private String calendartype;
    private String theme;
    private Integer mailformat;

    public CoreUserCreateUser() {
        super(WSFunctionEnum.CORE_USER_CREATE_USER);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public void setFrom(String from) {
        customfields.add(new CustomField("from", from));
    }

    public List<CustomField> getCustomfields() {
        return customfields;
    }

    public List<CustomField> getPreferences() {
        return preferences;
    }

    @Override
    public void addToMapParemeters() {
        if (password == null) {
            createpassword = 1;
        }
        if (username == null && email != null) {
            username = email;
        }
        // TODO implement multi-user-support
        putIfNotNull("users[0][createpassword]", createpassword);
        putIfNotNull("users[0][auth]", auth);
        putIfNotNull("users[0][firstname]", firstname);
        putIfNotNull("users[0][lastname]", lastname);
        putIfNotNull("users[0][username]", username);
        putIfNotNull("users[0][password]", password);
        putIfNotNull("users[0][email]", email);
        putIfNotNull("users[0][maildisplay]", maildisplay);
        putIfNotNull("users[0][city]", city);
        putIfNotNull("users[0][country]", country);
        putIfNotNull("users[0][timezone]", timezone);
        putIfNotNull("users[0][description]", description);
        putIfNotNull("users[0][firstnamephonetic]", firstnamephonetic);
        putIfNotNull("users[0][lastnamephonetic]", lastnamephonetic);
        putIfNotNull("users[0][middlename]", middlename);
        putIfNotNull("users[0][alternatename]", alternatename);
        putIfNotNull("users[0][interests]", interests);
        putIfNotNull("users[0][url]", url);
        putIfNotNull("users[0][icq]", icq);
        putIfNotNull("users[0][skype]", skype);
        putIfNotNull("users[0][aim]", aim);
        putIfNotNull("users[0][yahoo]", yahoo);
        putIfNotNull("users[0][msn]", msn);
        putIfNotNull("users[0][idnumber]", idnumber);
        putIfNotNull("users[0][institution]", institution);
        putIfNotNull("users[0][department]", department);
        putIfNotNull("users[0][phone1]", phone1);
        putIfNotNull("users[0][phone2]", phone2);
        putIfNotNull("users[0][address]", address);
        putIfNotNull("users[0][lang]", lang);
        putIfNotNull("users[0][calendartype]", calendartype);
        putIfNotNull("users[0][theme]", theme);
        putIfNotNull("users[0][mailformat]", mailformat);
        for (int i = 0; i < preferences.size(); i++) {
            CustomField customField = preferences.get(i);
            putIfNotNull("users[0][preferences][" + i + "][value]", customField.type);
            putIfNotNull("users[0][preferences][" + i + "][type]", customField.value);
        }
        for (int i = 0; i < customfields.size(); i++) {
            CustomField customField = customfields.get(i);
            putIfNotNull("users[0][customfields][" + i + "][value]", customField.type);
            putIfNotNull("users[0][customfields][" + i + "][type]", customField.value);
        }
    }

    private static class CustomField {

        private String type;
        private String value;

        public CustomField() {
        }

        public CustomField(String type, String value) {
            this.type = type;
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }

}
