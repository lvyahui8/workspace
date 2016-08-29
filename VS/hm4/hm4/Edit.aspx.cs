using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace hm4
{
    public partial class Edit : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void DeleteButton_Click(object sender, EventArgs e)
        {
            Response.Write("记录已删除，请<a href='3.aspx'>返回</a>");
        }

        protected void Back_Click(object sender, EventArgs e)
        {
            Response.Redirect("Default.aspx");
        }
    }
}