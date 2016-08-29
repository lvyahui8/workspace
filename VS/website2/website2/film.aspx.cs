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
    public partial class film : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            String level = Request.QueryString["level"];
            if ("1".Equals(level))
            {
                Response.Write("你是vip用户"); 
           
                this.Controls.Add(getTable(1));
                this.Controls.Add(getTable(2));
            }
            else if ("2".Equals(level))
            {
                Response.Write("你是普通用户");
                this.Controls.Add(getTable(2));
            }
            else
            {
                Response.Write("^_^你还没<a href='default.aspx'>登陆</a>呢");
            }
        }
        private Table getTable(int flag)
        {
            Table table = new Table();
            TableHeaderRow thr = new TableHeaderRow();
            TableHeaderCell thc = new TableHeaderCell();
            thc.Text = 1==flag ? "VIP电影" :"普通电影";
            thr.Cells.Add(thc);
            table.Rows.Add(thr);

            TableRow tr = new TableRow();
            for (int i = 0; i < 3; i++)
            {
                TableCell tc = new TableCell();
                tc.Text = 1==flag ?"vip电影1" : "普通电影1";
                tr.Cells.Add(tc);
            }
            table.Rows.Add(tr);
            return table;
        }
    }
}
