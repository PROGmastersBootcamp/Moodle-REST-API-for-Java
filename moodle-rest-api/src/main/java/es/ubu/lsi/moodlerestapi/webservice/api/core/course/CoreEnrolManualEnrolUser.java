package es.ubu.lsi.moodlerestapi.webservice.api.core.course;

import es.ubu.lsi.moodlerestapi.webservice.webservices.WSFunctionAbstract;
import es.ubu.lsi.moodlerestapi.webservice.webservices.WSFunctionEnum;

public class CoreEnrolManualEnrolUser extends WSFunctionAbstract {

    private Integer roleid;
    private Integer userid;
    private Integer courseid;
    private Integer timestart;
    private Integer timeend;
    private Integer suspend;

    public CoreEnrolManualEnrolUser() {
        super(WSFunctionEnum.CORE_ENROL_MANUAL_ENROL_USER);
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public void setTimestart(Integer timestart) {
        this.timestart = timestart;
    }

    public void setTimeend(Integer timeend) {
        this.timeend = timeend;
    }

    public void setSuspend(Integer suspend) {
        this.suspend = suspend;
    }

    @Override
    public void addToMapParemeters() {
        putIfNotNull("enrolments[0][roleid]", roleid);
        putIfNotNull("enrolments[0][userid]", userid);
        putIfNotNull("enrolments[0][courseid]", courseid);
        putIfNotNull("enrolments[0][timestart]", timestart);
        putIfNotNull("enrolments[0][timeend]", timeend);
        putIfNotNull("enrolments[0][suspend]", suspend);
    }

}
