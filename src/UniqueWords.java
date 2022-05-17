import java.io.IOException;
public class UniqueWords {
    private BookReader book = new BookReader("WarAndPeace.txt");

    public UniqueWords() throws IOException {
        addUniqueWordsToLinkedList();
    }

    public void addUniqueWordsToLinkedList() {
        long start, finish, difference;
        start = System.currentTimeMillis();
        System.out.println("Adding unique words using linkedList");
        String words = book.getWords().first();
        MyLinkedList<String> uniqueWords = new MyLinkedList<>();
        while (words != null) {
            if (!uniqueWords.contains(words)) {
                if(uniqueWords.isEmpty()) {
                    uniqueWords.addBefore(words);
                    uniqueWords.first();
                } else {
                    uniqueWords.addAfter(words);
                    uniqueWords.next();
                }
            }
            words = book.getWords().next();
        }
        System.out.println("Linked list unique words: " + uniqueWords.size());
        finish = System.currentTimeMillis();
        difference = finish - start;
        System.out.println("Time to process: " + difference / 1000 + " seconds.");
    }

}
