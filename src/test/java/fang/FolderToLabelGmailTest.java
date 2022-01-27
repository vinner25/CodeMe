package fang;

import com.vinner.codeme.fang.Folder;
import com.vinner.codeme.fang.FolderToLabelGmail;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FolderToLabelGmailTest {

    FolderToLabelGmail folderToLabelGmail = new FolderToLabelGmail();

    @Test
    public void testFolderToLabel()
    {
        Folder folder1 = new Folder(27,15,"projects");
        Folder folder2 = new Folder(81,27,"novel");
        Folder folder3 = new Folder(15,0,"personal");
        Folder folder4 = new Folder(35,27,"blog");

        List<String> labels = folderToLabelGmail.getStrings(new Folder[]{folder1,folder2, folder3, folder4});
        Assert.assertNotNull(labels);
    }
}
