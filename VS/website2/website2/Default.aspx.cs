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

namespace website2
{
    public partial class _Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void submitBtn_Click(object sender, EventArgs e)
        {
            String uname = username.Text;
            String pword = password.Text;
            if ("lvyahui".Equals(uname) && "hhjsw".Equals(pword))
            {
                Response.Redirect("film.aspx?level="+1);
            }
            else if ("lvyahui2".Equals(uname) && "hhjsw".Equals(pword))
            {
                Response.Redirect("film.aspx?level=" + 2);
            }
            else
            {
                Response.Write("登陆失败，用户名或密码错误");
            }
        }
    }
}
