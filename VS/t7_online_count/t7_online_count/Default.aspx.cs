using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace t7_online_count
{
    public partial class _Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            info.Text = "当前在线人数：" + Application[Global.ATTR_NAME];
            Response.AddHeader("Refresh", "2");
        }
    }
}
