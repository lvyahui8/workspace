using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace test01
{
    public partial class page01 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void CtrlChanged(object sender, EventArgs e) {
            string ctrlName = ((Control)sender).ID;
            listEvents.Items.Add(ctrlName + "Changed");
            listEvents.SelectedIndex = listEvents.Items.Count - 1;
        }
    }
}