using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace website3
{
    public partial class _Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack) {
                Response.Cookies["MyCookie"].Value = "OK";
                Response.Cookies["MyCookie"].Expires = DateTime.Now.AddMinutes(1);
                leb.Text = "Cookie Value:" + Request.Cookies["MyCookie"].Value + " Cookie LifeTime:" + Request.Cookies["MyCookie"].Expires;
            }
        }

        protected void btn_Click(object sender, EventArgs e)
        {
            if (Request.Cookies["MyCookie"] != null)
            {
                leb.Text = leb.Text + " Cookies is Life";
            }
            else
            {
                leb.Text = "MyCookie is Die";
            }
        }
    }
}
