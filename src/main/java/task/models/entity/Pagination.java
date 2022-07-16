//package task.models.entity;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class Pagination {
//    public static void setPagination(HttpServletRequest request, int total_records,int page_size, int current_page, String url){
//        request.setAttribute("total_records" ,total_records);
//        request.setAttribute("page_size" ,page_size);
//        request.setAttribute("current_page" , current_page);
//        request.setAttribute("url", url);
////        Integer total_records = (Integer) request.getAttribute("total_records");
////        Integer page_size = (Integer) request.getAttribute("page_size");
////        Integer current_page = (Integer) request.getAttribute( "current_page" );
//        int pages = total_records / page_size;
//        int lastPage = pages * page_size < total_records ? pages : pages - 1;
//        request.setAttribute("last_page", lastPage);
//        // сколько ссылок отображается начиная с самой первой (не может быть установлено в 0)
//        final int N_PAGES_FIRST = 1;
//        // сколько ссылок отображается слева от текущей (может быть установлено в 0)
//        final int N_PAGES_PREV = 1;
//        // сколько ссылок отображается справа от текущей (может быть установлено в 0)
//        final int N_PAGES_NEXT = 1;
//        // сколько ссылок отображается в конце списка страниц (не может быть установлено в 0)
//        final int N_PAGES_LAST = 1;
//        if (N_PAGES_FIRST < 1 || N_PAGES_LAST < 1) throw new AssertionError(  );
//        // показывать ли полностью все ссылки на страницы слева от текущей, или вставить многоточие
//        boolean showAllPrev;
//        // показывать ли полностью все ссылки на страницы справа от текущей, или вставить многоточие
//        boolean showAllNext;
//        showAllPrev = N_PAGES_FIRST >= (current_page - N_PAGES_PREV);
//        showAllNext = current_page + N_PAGES_NEXT >= lastPage - N_PAGES_LAST;
//        request.setAttribute( "N_PAGES_FIRST", N_PAGES_FIRST );
//        request.setAttribute( "N_PAGES_PREV", N_PAGES_PREV );
//        request.setAttribute( "N_PAGES_NEXT", N_PAGES_NEXT );
//        request.setAttribute( "N_PAGES_LAST", N_PAGES_LAST );
//        request.setAttribute( "showAllPrev", showAllPrev );
//        request.setAttribute( "showAllNext", showAllNext );
//    }
//
//    public static void processPagination(HttpServletRequest request){
//        String pagination_arg = request.getRequestURI();
//        String[] args = pagination_arg.split("&");
//        for(int i = 1; i<args.length; i++){
//            String[] mas = args[i].split("=");
//            request.setAttribute(mas[0], Integer.parseInt(mas[1]));
//        }
//    }
//}
//
