/*
 *
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 *
 */
package demo.townsend.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import demo.townsend.common.Constants;
import demo.townsend.form.AddToListForm;
import demo.townsend.service.DataKeeper;
import demo.townsend.service.Product;
import demo.townsend.service.ProductCatalog;
import com.generic.cache.CacheDAO;
import com.generic.cache.CacheDAOFactory;

/**
 * AddToListAction processes the request to add an item to the user's list.
 * User's list is fetched from the HttpSession object, the item indicated in the
 * AddToListForm is added to the list, and the modified list is loaded back into
 * the HttpSession object.
 */
public class AddToListAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String newProdId = ((AddToListForm) form).getId();
		System.out.println("newProdId= " + newProdId);
		Product newProd = null;
		List<Product> catalog = new ProductCatalog().getCatalog();
		for (Iterator<Product> iter = catalog.iterator(); iter.hasNext();) {
			Product p = iter.next();
			if (p.getId().equals(newProdId)) {
				newProd = p;
			}
		}

		CacheDAO dao = CacheDAOFactory.getCacheDAO();
		DataKeeper dkeeper = (DataKeeper) dao.getAttribute(Constants.DATA_KEY);
		if (dkeeper == null) {
			dkeeper = new DataKeeper();
		}

		dkeeper.addListItem(newProd);
		dao.setAttribute(Constants.DATA_KEY, dkeeper);

		return mapping.findForward(Constants.SUCCESS_KEY);
	}
}
