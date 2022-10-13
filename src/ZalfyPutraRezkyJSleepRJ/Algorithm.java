package ZalfyPutraRezkyJSleepRJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Algorithm{
    private Algorithm(){
    }

    /** COLLECT */
    public static <T> List<T> collect(Iterable<T> iterable, T value){
        Predicate<T> predicate = value::equals;
        return collect(iterable.iterator(), predicate);
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred){
        return collect(iterable.iterator(), pred);
    }

    public static <T> List<T> collect(T[] array, T value){
        Predicate<T> predicate = value::equals;
        return collect(Arrays.stream(array).iterator(), predicate);
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value){
        Predicate<T> predicate = value::equals;
        return collect(iterator, predicate);
    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred){
        return collect(Arrays.stream(array).iterator(), pred);
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred){
        List<T> list = new ArrayList<>();
        T obj;
        while (iterator.hasNext()){
            obj = iterator.next();
            if (pred.predicate(obj))
                list.add(obj);
        }
        return list;
    }

    /** COUNT */
    public static <T> int count(Iterator<T> iterator, T value){
        int count = 0;
        while(iterator.hasNext())
            if(iterator.next().equals(value)) count++;
        return count;
    }
  
    public static <T> int count(T[] array, T value){
        return count(Arrays.asList(array).iterator(), value);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> predicate){
        int count = 0;
        while(iterator.hasNext())
            if(predicate.predicate(iterator.next())) count++;
        return count;
    }

    public static <T> int count(Iterable<T> iterable, T value){
        return count(iterable.iterator(), value);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> predicate){
        int count = 0;
        for (T t : iterable)
            if(predicate.predicate(t)) count++;
        return count;
    }
  
    public static <T> int count(T[] array, Predicate<T> predicate){
        return count(Arrays.asList(array).iterator(), predicate);
    }

    /** EXISTS */
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }
  
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()){
            T current = iterator.next();
            if(pred.predicate(current)) return true;
        }
        return false;
    }

    public static <T> boolean exists(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }
  
    public static <T> boolean exists(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    /** FIND */
    public static <T> T find(Iterable<T> iterable, T value){
        final Predicate<T> pred = value::equals;
        return find(iterable, pred);
    }

    public static <T> T find(T[] array, Predicate<T> pred){
        for (T t : array)
            if(pred.predicate(t)) return t;
        return null;
    }
  
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred){
        for (T t : iterable)
            if(pred.predicate(t))
                return t;
        return null;
    }
  
    public static <T> T find(T[] array, T value){
        final Predicate<T> pred = value::equals;
        return find(array, pred);
    }

    public static <T> T find(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }
  
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred){
        while (iterator.hasNext()){
            T current = iterator.next();
            if(pred.predicate(current))
                return current;
        }
        return null;
    }

    /** PAGINATE */
    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred){
        return paginate(Arrays.stream(array).iterator(), page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred){
        int it = 0, occ = 0, start = page * pageSize;
        List<T> pageList = new ArrayList<>(pageSize);
        List<T> array = new ArrayList<>();
        iterator.forEachRemaining(array::add);
        for (; it < array.size() && occ < start; it++) {
            if (pred.predicate(array.get(it)))
                occ++;
        }
        for (int i = 0; i < array.size() && pageList.size() < pageSize; i++) {
            if (pred.predicate(array.get(it)))
                pageList.add(array.get(it));
        }
        return pageList;
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred){
        List<T> list = new ArrayList<>();
        int counter = 0, printCounter = 0, size = page * pageSize;
        for (T each : iterable){
            if (counter < size && pred.predicate(each)){
                counter++;
                continue;
            }
            if (printCounter < pageSize && pred.predicate(each)){
                list.add(each);
                printCounter++;
            }
            else break;
        }
        return list;
    }
}