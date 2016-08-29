function SetPrintSettings() { 
　// -- advanced features 
　factory.printing.SetMarginMeasure(2) // measure margins in inches 
　factory.SetPageRange(false, 1, 3) // need pages from 1 to 3 
　factory.printing.printer = "HP DeskJet 870C" 
　factory.printing.copies = 2 
　factory.printing.collate = true 
　factory.printing.paperSize = "A4" 
　factory.printing.paperSource = "Manual feed" 

　// -- basic features 
　factory.printing.header = "This is MeadCo" 
　factory.printing.footer = "Advanced Printing by ScriptX" 
　factory.printing.portrait = false 
　factory.printing.leftMargin = 1.0 
　factory.printing.topMargin = 1.0 
　factory.printing.rightMargin = 1.0 
　factory.printing.bottomMargin = 1.0 
} 

　　function printsetup(){ 
　　// 打印页面设置 
　　wb.execwb(8,1); 
　　} 
　　function printpreview(){ 
　　// 打印页面预览 
　　　　 
　　wb.execwb(7,1); 
　　　　　 
　　　　 
　　} 

　　function printit() 
　　{ 
　　if (confirm('确定打印吗？')) { 
　　wb.execwb(6,6) 
　　} 
　　} 
function CloseWindow()
{
wb.ExecWB(45,1);
}
