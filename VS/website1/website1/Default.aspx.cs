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
    public partial class _Default : System.Web.UI.Page
    {
        private string var1 = "yongzhou";
        private string var2 = "haikou";
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void ResponseBtn_Click(object sender, EventArgs e)
        {
            Response.Redirect("other.aspx?var1=" + var1 + "&var2=" + var2);
        }

        protected void CookieBtn_Click(object sender, EventArgs e)
        {
            Response.Cookies["var1"].Value = var1;
            Response.Cookies["var2"].Value = var2;
            Response.Redirect("other.aspx");
        }

        protected void SessionBtn_Click(object sender, EventArgs e)
        {
            Session["var1"] = var1;
            Session["var2"] = var2;
            Response.Redirect("other.aspx");
        }
    }
}
