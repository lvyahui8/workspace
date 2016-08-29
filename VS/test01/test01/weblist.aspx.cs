using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace test01
{
    public partial class weblist : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!Page.IsPostBack)
            {
                for (int i = 3; i <= 5;i++ )
                {
                    Listbox1.Items.Add("Option " + i.ToString());
                    Dropdwonlist1.Items.Add("Option " + i.ToString());
                    CheckboxList1.Items.Add("Option " + i.ToString());
                    RadiobuttonList1.Items.Add("Option " + i.ToString());
                }
            }
        }

        protected void Button1_Click(object sender, EventArgs e) {
            Response.Write("<b>Slelect items fot Listbox1:</b><br />");
            foreach (ListItem li in Listbox1.Items)
            {
                if (li.Selected)
                {
                    Response.Write("-" + li.Text + "<br />");
                }
            }
            Response.Write("<b>Select item for Dropdown1:</b><br />");
            Response.Write("-" + Dropdwonlist1.SelectedItem.Text + "<br />");

            Response.Write("<b>Select items for CheckboxList1:</b><br />");
            foreach (ListItem li in CheckboxList1.Items) { 
                if (li.Selected)
                {
                    Response.Write("-" + li.Text + "<br />");
                }
            }

            Response.Write("<b>Selectd item for Radiobuttonlist1:</b><br />");
            Response.Write("-" + RadiobuttonList1.SelectedItem.Text + "<br/>");
        }
    }
}