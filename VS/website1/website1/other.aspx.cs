using System;
using System.Collections;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Xml.Linq;

namespace website1
{
    public partial class other : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string respVar1 = Request.QueryString["var1"];
            string respVar2 = Request.QueryString["var2"];
            if (respVar1 != null)
            {
                Response.Write("这是通过response对象的参数var1" + respVar1 + "..var2" + respVar2);
                return;
            }
            string sessionVar1 = (string)(Session["var1"]);
            string sessionVar2 = (string)(Session["var2"]);
            if (sessionVar1 != null)
            {
                Response.Write("这是通过session对象的参数var1" + sessionVar1 + "..var2" + sessionVar2);
                return;
            }
            string cookiesVar1 = Request.Cookies["var1"].Value;
            string cookiesVar2 = Request.Cookies["var2"].Value;
            if (cookiesVar1 != null)
            {
                Response.Write("这是通过cookies对象的参数var1" + cookiesVar1 + "..var2" + cookiesVar2);
                return;
            }
            
        }
    }
}
