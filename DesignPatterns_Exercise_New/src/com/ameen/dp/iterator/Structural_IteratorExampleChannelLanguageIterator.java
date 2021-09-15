package com.ameen.dp.iterator;

import java.util.ArrayList;
import java.util.List;

public class Structural_IteratorExampleChannelLanguageIterator {
    public static void main(String[] args) {
        ChannelCollection channels = populateChannels();
        ChannelIterator baseIterator = channels.iterator(ChannelLanguage.ALL);
        while (baseIterator.hasNext()) {
            Channel c = baseIterator.next();
            System.out.println(c.toString());
        }
        System.out.println("******");
        // Channel Type Iterator
        ChannelIterator englishIterator = channels.iterator(ChannelLanguage.ENGLISH);
        while (englishIterator.hasNext()) {
            Channel c = englishIterator.next();
            System.out.println(c.toString());
        }
    }

    private static ChannelCollection populateChannels() {
        ChannelCollection channels = new ChannelCollectionImpl();
        channels.addChannel(new Channel(98.5, ChannelLanguage.ENGLISH));
        channels.addChannel(new Channel(99.5, ChannelLanguage.TAMIL));
        channels.addChannel(new Channel(100.5, ChannelLanguage.FRENCH));
        channels.addChannel(new Channel(101.5, ChannelLanguage.ENGLISH));
        channels.addChannel(new Channel(102.5, ChannelLanguage.TAMIL));
        channels.addChannel(new Channel(103.5, ChannelLanguage.FRENCH));
        channels.addChannel(new Channel(104.5, ChannelLanguage.ENGLISH));
        channels.addChannel(new Channel(105.5, ChannelLanguage.TAMIL));
        channels.addChannel(new Channel(106.5, ChannelLanguage.FRENCH));
        return channels;
    }
}

enum ChannelLanguage {
    ENGLISH, TAMIL, FRENCH, ALL;
}

class Channel {
    private double frequency;
    private ChannelLanguage LANGUAGE;

    public Channel(double freq, ChannelLanguage LANGUAGE) {
        this.frequency = freq;
        this.LANGUAGE = LANGUAGE;
    }

    public double getFrequency() {
        return frequency;
    }

    public ChannelLanguage getLANGUAGE() {
        return LANGUAGE;
    }

    @Override
    public String toString() {
        return "Frequency=" + this.frequency + ", Type=" + this.LANGUAGE;
    }
}

interface ChannelIterator {
    public boolean hasNext();

    public Channel next();
}

interface ChannelCollection {
    public void addChannel(Channel c);

    public void removeChannel(Channel c);

    public ChannelIterator iterator(ChannelLanguage language);
}

class ChannelCollectionImpl implements ChannelCollection {

    private List<Channel> channelsList;

    public ChannelCollectionImpl() {
        channelsList = new ArrayList<>();
    }

    public void addChannel(Channel c) {
        this.channelsList.add(c);
    }

    public void removeChannel(Channel c) {
        this.channelsList.remove(c);
    }

    @Override
    public ChannelIterator iterator(ChannelLanguage language) {
        return new ChannelIteratorImpl(language, this.channelsList);
    }

    private class ChannelIteratorImpl implements ChannelIterator {

        private ChannelLanguage channelLanguage;
        private List<Channel> channels;
        private int position;

        public ChannelIteratorImpl(ChannelLanguage channelLanguage,
                                   List<Channel> channelsList) {
            this.channelLanguage = channelLanguage;
            this.channels = channelsList;
        }

        @Override
        public boolean hasNext() {
            while (position < channels.size()) {
                Channel c = channels.get(position);
                if (c.getLANGUAGE().equals(channelLanguage) || channelLanguage.equals(ChannelLanguage.ALL)) {
                    return true;
                } else
                    position++;
            }
            return false;
        }

        @Override
        public Channel next() {
            Channel c = channels.get(position);
            position++;
            return c;
        }

    }
}