/*
 *
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 *
*/
package demo.townsend.action;

import demo.townsend.common.Constants;
import demo.townsend.service.DataKeeper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.generic.cache.CacheDAO;
import com.generic.cache.CacheDAOFactory;

/**
 * WelcomeAction initializes objects used by display.jsp 
 */
public class WelcomeAction extends Action {
   public ActionForward execute( ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
    throws Exception {

      CacheDAO dao = CacheDAOFactory.getCacheDAO();
      try{
      dao.getAttribute(Constants.DATA_KEY);
      }catch (Exception e) {
        DataKeeper dkeeper = new DataKeeper();
        dao.setAttribute( Constants.DATA_KEY, dkeeper);
      }
      return mapping.findForward(Constants.SUCCESS_KEY );
  }
}
