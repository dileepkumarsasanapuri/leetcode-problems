class Solution {
    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int totalSpaces = text.length() - text.replace(" ", "").length();
        int spacesBetween = words.length > 1 ? totalSpaces / (words.length - 1) : 0;
        int extraSpaces = words.length > 1 ? totalSpaces % (words.length - 1) : totalSpaces;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);
            int temp=spacesBetween;
            if(i<words.length-1){
            while(temp>0){
                result.append(" ");
                temp--;
            }
            }
        }
        while(extraSpaces>0){
            result.append(" ");
            extraSpaces--;
        }
        return result.toString();
    }
}



    //    String [] words=text.trim().split("\\s+");
    //    int totalspaces = text.length()-text.replace(" ","").length();
    //    int betweenspaces=words.length>1 ? totalspaces / (words.length-1):0;
    //    int endspaces=words.length>1 ? totalspaces % (words.length-2):totalspaces;
    //   String answer="";
    //   for(int i=0;i<words.length;i++){
    //     answer +=words[i];
    //     int temp=betweenspaces;
    //     while(temp>0){
    //         answer +=" ";
    //         temp--;
    //     }
    //   }
    //   while(endspaces>0) {
    //     answer+=" ";
    //     endspaces--;
    //   }
    //   return answer;
//     }
// }