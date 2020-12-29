package ru.netology;

import java.util.*;

public class FileOpen {

    Map<String, Set<String>> fileOpen = new HashMap<>();

    public void addAppExtensions(String name, Set<String> extensions) {
        for(String extension: extensions) {
            addAppExtension(name, extension);
        }
    }

    public void addAppExtension(String name, String extension) {
        Set<String> temp = new HashSet<>(fileOpen.getOrDefault(name, Set.of()));
        temp.add(extension.toLowerCase());
        fileOpen.put(name, temp);
    }

    public Set<String> getAppByExtension(String extension) {
        if (!getExtensions().contains(extension))
            return null;
        Set<String> result = new HashSet<>();
        for (Map.Entry<String, Set<String>> entry : fileOpen.entrySet()) {
            for (String ext : entry.getValue()) {
                if (ext.equalsIgnoreCase(extension)) {
                    result.add(entry.getKey());
                    break;
                }
            }
        }
        return result;
    }

    public void deleteTie(String name, String extension) {
        Set<String> temp = fileOpen.get(name);
        if(temp == null || !temp.contains(extension))
            return;
        temp.remove(extension.toLowerCase());
        if (temp.isEmpty())
            fileOpen.remove(name);
         else
            fileOpen.replace(name, temp);
    }

    public Set<String> getApps() {
        return fileOpen.keySet();
    }

    public Set<String> getExtensions() {
        Set<String> result = new HashSet<>();
        for (Set<String> extensions : fileOpen.values()) {
            result.addAll(extensions);
        }
        return result;
    }

    public Map<String, Set<String>> getFileOpen() {
        return fileOpen;
    }
}
